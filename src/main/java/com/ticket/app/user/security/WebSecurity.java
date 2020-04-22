package com.ticket.app.user.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ticket.app.user.service.UsersService;


@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	private Environment enviroment;
	private UsersService userService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public WebSecurity(Environment enviroment, UsersService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.enviroment = enviroment;
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
		
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/**").hasIpAddress(enviroment.getProperty("gateway.ip"))
		.and()
		.addFilter(getAuthenticationFilter());
	}
	
	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(userService, enviroment, authenticationManager());
		authenticationFilter.setFilterProcessesUrl(enviroment.getProperty("login.url.path"));
		return authenticationFilter;
	}
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }


}
