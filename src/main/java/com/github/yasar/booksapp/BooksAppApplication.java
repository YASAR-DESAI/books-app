package com.github.yasar.booksapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableWebSecurity
public class BooksAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksAppApplication.class, args);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/swagger-ui",
								"/books",
								"/swagger-ui/**",
								"/v3/api-docs/**",
								"/actuator",
								"/actuator/**").permitAll()
						.anyRequest().authenticated()
				);
		return http.build();
	}

}
