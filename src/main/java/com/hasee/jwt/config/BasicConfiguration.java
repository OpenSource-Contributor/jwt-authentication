package com.hasee.jwt.config;

import com.hasee.jwt.jwt.AuthEntryPointJwt;
import com.hasee.jwt.jwt.AuthTokenFilter;
import com.hasee.jwt.service.auth.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Copyright (c) 2021. scicom.com.my - All Rights Reserved.
 * Created by amarathunga.h on 1/6/22, 9:47 AM.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		//		securedEnabled = true,
		//		jsr250Enabled = true,
		prePostEnabled = true)
public class BasicConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter()
	{
		return new AuthTokenFilter();
	}

	@Override
	public void configure( AuthenticationManagerBuilder authenticationManagerBuilder ) throws Exception
	{
		authenticationManagerBuilder.userDetailsService( userDetailsService ).passwordEncoder( passwordEncoder() );
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests()
				.antMatchers("/auth/**").permitAll();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}