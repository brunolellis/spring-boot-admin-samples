package com.brunolellis.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class UserApiConfiguration extends WebSecurityConfigurerAdapter {

	@Value("${spring.boot.admin.client.instance.metadata.user.name:}")
	private String sbaUsername;
	
	@Value("${spring.boot.admin.client.instance.metadata.user.password:}")
	private String sbaPassword;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/api/**").permitAll()
			.anyRequest()
			.authenticated()
			.and().formLogin()
			.and().httpBasic();
	}
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        	.passwordEncoder(NoOpPasswordEncoder.getInstance())
        	.withUser(sbaUsername)
            .password(sbaPassword)
            .roles("USER");
    }

}
