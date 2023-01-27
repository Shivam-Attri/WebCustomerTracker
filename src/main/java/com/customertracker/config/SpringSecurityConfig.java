package com.customertracker.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
		@Autowired
		DataSource dataSource;

	    @Bean
	    public UserDetailsManager userDetailsManager() {
	    	return new JdbcUserDetailsManager(dataSource);
	    }
	    
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    	return http.authorizeRequests(configurer->configurer
	    												.antMatchers("/css/**").permitAll()
	    												.antMatchers("/customer/list/**").hasAnyRole("USER")
	    												.antMatchers("/customer/showFormForAdd/**").hasAnyRole("ADMIN")
	    												.antMatchers("/customer/saveCustomer/**").hasAnyRole("ADMIN")
	    												.antMatchers("/customer/updateCustomer/**").hasAnyRole("ADMIN")
	    												.antMatchers("/customer/deleteCustomer/**").hasAnyRole("ADMIN")
	    												.antMatchers("/customer/searchCustomers/**").hasAnyRole("ADMIN","EMPLOYEE")
	    												)
	    				.formLogin(configurer->{
							try {
																configurer
																.loginPage("/login")
																.loginProcessingUrl("/login").permitAll()
																.and()
																.logout().permitAll()
																.and()
																.exceptionHandling().accessDeniedPage("/access-denied");
							} catch (Exception e) {
								e.printStackTrace();
							}
						})
	    				.build();
	    }
}
