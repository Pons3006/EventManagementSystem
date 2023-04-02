package com.example.pons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	 InMemoryUserDetailsManager userDetailService() {
		
		UserDetails user=User.withUsername("Pons").password(encoder().encode("Pons@1234")).roles("ORGANIZER").build();
		return new InMemoryUserDetailsManager(user);
		
	}
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
        .authorizeHttpRequests()
        	.requestMatchers("/attendees/**").hasRole("ORGANIZER")
        	.requestMatchers("/iplevents/**").hasRole("ORGANIZER")
        	.requestMatchers("/attendeeslist").hasRole("ORGANIZER")
        	.requestMatchers("/ipleventslist").permitAll()
        	.anyRequest().authenticated()
        	.and()
            .httpBasic();
        
		return http.build();
	}
}
