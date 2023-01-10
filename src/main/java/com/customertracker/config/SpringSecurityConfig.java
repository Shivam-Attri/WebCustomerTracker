package com.customertracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	    @Bean
	    public InMemoryUserDetailsManager userDetailsManager() {
	    	UserDetails user1=User.withDefaultPasswordEncoder().username("Shivam").password("Test@123").roles("ADMIN","USER").build();
	    	UserDetails user2=User.withDefaultPasswordEncoder().username("Attri").password("Testing").roles("EMPLOYEE","USER").build();
	    	return new InMemoryUserDetailsManager(user1,user2);
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
																.logout().permitAll();
							} catch (Exception e) {
								e.printStackTrace();
							}
						})
	    				.build();
	    }
}
