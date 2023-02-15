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
public class DataUserConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth
			.jdbcAuthentication().dataSource(dataSource)
			//,'true' as enabled porque no tenemos enabled
			.usersByUsernameQuery("select email, password, enabled from Usuarios where email=?")
			.authoritiesByUsernameQuery("select u.email, r.nombre_rol from Usuarios_Con_Roles up " +  "inner join Usuarios u on u.email = up.email " +
	"inner join Roles r on r.id_rol = up.id_rol " +  "where u.email = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.csrf().disable()
			.authorizeRequests()
			// Los directorios estáticos no requieren autenticacion
			.antMatchers("/bootstrap/**",  "/images/**", "/css/**", "js/**").permitAll()
			.antMatchers("/rest/demo-bcrypt/**").permitAll()
			
			// Las vistas públicas no requieren autenticación
			.antMatchers("/", "/login", "/logout", "/registro","/search", "/app/producto/verUno/**").permitAll()
			// Las autorizaciones sobre urls para ROLES
			.antMatchers("/app/producto/**").hasAnyAuthority("ROLE_CLIENTE","ROLE_ADMINISTRADOR")
			.antMatchers("/app/usuarios/**").hasAnyAuthority("ROLE_CLIENTE","ROLE_ADMINISTRADOR")
			.antMatchers("/app/roles/**").hasAnyAuthority("ROLE_ADMINISTRADOR")
			.antMatchers("/app/tipos/**").hasAnyAuthority("ROLE_CLIENTE")
			
			// Todas las demás URLs de la Aplicación requieren autenticación
			.anyRequest().authenticated()
			// El formulario de Login no requiere autenticacion
			.and().formLogin().permitAll()
			// El formulario de logout no requiere autenticacion
	//		.and().logout().permitAll()
			;
			
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	

}
