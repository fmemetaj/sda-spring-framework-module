package com.java38.spring_framework.exercises.task12;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(request ->
                request.requestMatchers(HttpMethod.GET, "/api/cars").hasAnyRole("ADMIN", "CARS"));

        http.authorizeHttpRequests(request ->
                request.requestMatchers(HttpMethod.POST, "/api/cars").authenticated());

        http.authorizeHttpRequests(request ->
                request.requestMatchers("/api/users/**").hasRole("USER_ADMIN"));

        http.authorizeHttpRequests(request -> request.anyRequest().permitAll());

        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}Secret_123")
                .roles("ADMIN", "CARS")
                .build();

        UserDetails admin2 = User.builder()
                .username("admin2")
                .password("{noop}Secret_123")
                .roles("USER_ADMIN")
                .build();

        UserDetails admin3 = User.builder()
                .username("admin3")
                .password("{noop}Secret_123")
                .roles("CARS")
                .build();


        return new InMemoryUserDetailsManager(admin, admin2, admin3);
    }

}
