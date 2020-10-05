package learn.springrest.crud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 To configure spring security ,extend SpringSecurityConfiguration and override two methods 
 configure(AuthenticationManagerBuilder auth) and configure(AuthenticationManagerBuilder auth)
 
 Select 'Basic Auth' in 'Postman'
 
 */
@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	/* For the authentication, we have added two users’ root and test.
	  Here root is a user as well as admin,  whereas, the test is just a user.
	  HTTP GET can be called by a user (test and root), Whereas, HTTP POST, PUT, and DELETE can only be called by admin.
	  */
     
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("root").password("{noop}linux").roles("USER", "ADMIN").and()
				.withUser("test").password("{noop}test123").roles("USER");
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/**").hasRole("USER")
				.antMatchers(HttpMethod.POST, "/api/v1").hasRole("ADMIN").antMatchers(HttpMethod.PUT, "/api/v1/**")
				.hasRole("ADMIN").antMatchers(HttpMethod.PATCH, "/api/user/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/v1/**").hasRole("ADMIN").and().csrf().disable().formLogin()
				.disable();
	}
}
