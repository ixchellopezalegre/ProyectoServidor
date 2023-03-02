package com.edix.proyecto.configuracion;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityData extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	/*Configuración de la base de datos*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{

		auth
			.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("SELECT email, password, 'true' as enabled FROM Usuarios " +
					"WHERE email=?")
			//Como el email es unico, podemos encontrar el usuario
				// por el email, haciendo un INNER JOIN de dicho usuario a través
					// del id_usuario de la tabla USUARIOS_CON_ROLES
			.authoritiesByUsernameQuery("SELECT u.id_usuario," +
					" r.nombre_rol " +
					"from USUARIOS_CON_ROLES ur" +
					" INNER JOIN Usuarios u " +
					"ON u.id_usuario = ur.id_usuario " +
					"INNER JOIN Roles r " +
					"ON r.id_rol = ur.id_rol " +
					"where u.email =?");
	}
	
	/*Configuración de las URLS*/
	@Override
	protected void configure(HttpSecurity http) throws Exception{

		http
			.csrf().disable() /*Deshabilitar token de nuestros formularios*/
			.authorizeRequests() /*Autorizar las peticiones que definimos a continuación */
				.antMatchers().permitAll() /*Solo si en resource -> statics tenemos contenido*/
				.antMatchers("/"
						,"/logout"
						,"/registro"
						,"/producto/todos"
						,"/producto/verUno/{idProducto}"
						,"/producto/orden/alfabetico/asc"
						,"/producto/orden/alfabetico/desc"
						,"/producto/orden/precio/asc"
						,"/producto/orden/precio/desc"
						,"/rest/producto/buscar/{id}"
						,"/rest/producto/tipo/{tipo}"
						,"/rest/provincias/todas"
						,"/rest/provincias/buscar/{localidad}"
						,"/rest/usuarios/buscar/{localidad}"
						,"/producto/buscar").permitAll()
				//URLS que permitimos de acceso público. los ** son comodines para informar 
				//que puede haber mas información a partir de esa URL
				
				.antMatchers("/encriptar/**").permitAll()
				.anyRequest().authenticated() /*Cualquier otra petición necesita registro*/
				.and()
				.formLogin()
						.defaultSuccessUrl("/inicio", true)
						//Si el Login es Correcto, nos lleva a /inicio que procesa el login manualmente
				.permitAll();
			/*AUTENTICACION SOBRE ROLES*/
			/*.antMatchers("URL").hasAnyAuthority("ROL QUE PERMITIMOS A ESA URL")*/
			/*Esto se combina con los JSP con las directivas <c:>*/
	}

	/*
	Para encriptar la contraseña antes de guardarla en la base de datos
	y para poder comparar con la que nos pasen
	 */
	@Bean
	public PasswordEncoder passwordEncorder (){

		return new BCryptPasswordEncoder();
	}
}
