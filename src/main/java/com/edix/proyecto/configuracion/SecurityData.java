package com.edix.proyecto.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityData extends WebSecurityConfigurerAdapter {
	
	
	/*Configuración de la base de datos*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		super.configure(auth);
	}
	
	/*Configuración de las URLS*/
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http
			.csrf().disable() /*Deshabilitar token de nuestros formularios*/
			.authorizeRequests() /*Autorizar las peticiones que definimos a continuación */
			.antMatchers().permitAll() /*Solo si en resource -> statics tenemos contenido*/
			.antMatchers("/","/login","/logout","/user/registro","search").permitAll() /*URLS que permitimos de acceso público. los ** son comodines para informar que puede haber mas información a partir de esa URL*/
			
			/*AUTENTICACION SOBRE ROLES*/
			/*.antMatchers("URL").hasAnyAuthority("ROL QUE PERMITIMOS A ESA URL")*/
			/*Esto se combina con los JSP con las directivas <c:>*/
			
			.anyRequest().authenticated() /*Cualquier otra petición necesita registro*/
			.and().formLogin().permitAll(); /*El formulario de Login si lo permitimos*/
			
			
		
		
	}

}
