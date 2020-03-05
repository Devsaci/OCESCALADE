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
        http.authorizeRequests().antMatchers("/ListeSites").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/Site").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/NewSpot").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/Topo").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/Profil").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/saveSite").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/saveSecteur").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/saveVoie").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/saveTopo").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/topoPret").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/acceptPret").hasAnyRole("USER","ADMIN");
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login");
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
