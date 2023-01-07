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
	    	UserDetails user1=User.withDefaultPasswordEncoder().username("Shivam").password("Test@123").roles("ADMIN").build();
	    	UserDetails user2=User.withDefaultPasswordEncoder().username("Attri").password("Testing").roles("EMPLOYEE").build();
	    	UserDetails user3=User.withDefaultPasswordEncoder().username("Vishu").password("12345").roles("CUSTOMER").build();
	    	return new InMemoryUserDetailsManager(user1,user2,user3);
	    }
	    
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    	return http.authorizeRequests(configurer->configurer
	    												.anyRequest()
	    												.authenticated())
	    				.formLogin(configurer->configurer
	    												.loginPage("/login")
	    												.loginProcessingUrl("/login")
	    												.permitAll())
	    				.build();
	    }
}
