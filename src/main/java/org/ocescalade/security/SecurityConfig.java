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
import org.springframework.security.crypto.password.PasswordEncoder;

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
		 System.out.println("code 1234"+bcpe.encode("1234"));
		 System.out.println("code 1111"+bcpe.encode("1111"));
		 System.out.println("code 2222"+bcpe.encode("2222"));
		 System.out.println("code 3333"+bcpe.encode("3333"));


		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT username as principal, password as credentials,"
						+ " enabled FROM user WHERE username=?")
				.authoritiesByUsernameQuery("SELECT username as principal, role as role FROM user WHERE username=?")
				.rolePrefix("ROLE_").passwordEncoder(getBCPE());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * super.configure(http);
		 */

		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/Accueil").hasAnyRole("USER", "ADMIN");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

}
