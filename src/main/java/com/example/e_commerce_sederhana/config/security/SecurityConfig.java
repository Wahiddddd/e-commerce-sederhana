package com.example.e_commerce_sederhana.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/products/**").hasRole("SELLER")
                .requestMatchers("/orders/**").hasRole("BUYER")
                .anyRequest().authenticated()
        );

        http.addFilterBefore(
                new JwtFilter(),
                UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }
}