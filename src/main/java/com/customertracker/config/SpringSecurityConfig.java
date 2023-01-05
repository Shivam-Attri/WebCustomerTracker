package com.customertracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
}
