package com.tomashchuk.GallProj.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityWebApplicationConfig extends WebSecurityConfigurerAdapter {

	//	@Autowired
//	private UserDetailsService userDetailsService;

/*	@Autowired
	private DataSource dataSource;
	//@Autowired
	//private PasswordEncoder passwordEncoder;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		//.passwordEncoder(passwordEncoder)
		.authoritiesByUsernameQuery("SELECT userId, login, password FROM user WHERE login=?")
		.usersByUsernameQuery("SELECT userId, login, role FROM user WHERE login=?");//userDetailsService(userDetailsService);
	}

	
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");

	}
*/
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");

	}

	protected void configure(HttpSecurity http) throws Exception {
		//smplUser
		//admin
		http
		.authorizeRequests()
		.antMatchers("/admin*").access("hasAuthority('ADMIN')") 
		.antMatchers("/smplUser*").access("hasAuthority('SMPLUSER')") 
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login")
				.usernameParameter("login").passwordParameter("password").permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/")
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")).permitAll()
				.and()
				.csrf().disable();

	}

}
