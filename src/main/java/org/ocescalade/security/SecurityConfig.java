package org.ocescalade.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	
		BCryptPasswordEncoder bcpe = getBCPE();
		System.out.println(bcpe.encode("1234"));
		System.out.println(bcpe.encode("5555"));
		
		/*      */
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("SELECT username as principal, password as credentials,"
				+ " enabled FROM user WHERE username=?")
		.authoritiesByUsernameQuery(
				"SELECT username as principal, role as role FROM user WHERE username=?")
		.rolePrefix("ROLE_")
		.passwordEncoder(getBCPE())
		;
		
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		/* 
		 super.configure(http);		 
		*/	
		
		 http.formLogin().loginPage("/login");
		 http.authorizeRequests().antMatchers("/").hasAnyRole("USER","ADMIN");
		 http.authorizeRequests().antMatchers("/Accueil").hasAnyRole("USER","ADMIN");		 		 
	}
	
	
	@Bean
	BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
	
}
