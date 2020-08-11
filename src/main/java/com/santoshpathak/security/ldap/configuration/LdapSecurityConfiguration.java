/**
 * 
 */
package com.santoshpathak.security.ldap.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

/**
 * @author santoshpathak
 *
 */
@Configuration
@EnableWebSecurity
public class LdapSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	/**
	 * LDAP seed file (ldap-data.ldif) downloaded from  https://spring.io/guides/gs/authenticating-ldap/
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
	      .ldapAuthentication()
	        .userDnPatterns("uid={0},ou=people")
	        .groupSearchBase("ou=groups")
	        .contextSource()
	          .url("ldap://localhost:8389/dc=springframework,dc=org")
	          .and()
	        .passwordCompare()
	          .passwordEncoder(new BCryptPasswordEncoder())
	          .passwordAttribute("userPassword");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
		 	.authorizeRequests()
		 	.anyRequest()
		 	.fullyAuthenticated()
		 	.and()
		 	.formLogin();
		 	
	}
}
