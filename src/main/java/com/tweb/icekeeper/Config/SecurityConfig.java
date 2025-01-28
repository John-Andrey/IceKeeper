package com.tweb.icekeeper.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/public/**").permitAll() // Public endpoints
                        .requestMatchers(HttpMethod.POST, "/api/users/**").hasRole("ADMIN") // Admin access for creating users
                        .requestMatchers(HttpMethod.PUT, "/api/users/**").hasRole("ADMIN") // Admin access for updating users
                        .requestMatchers(HttpMethod.GET, "/api/glaciers").hasAnyRole("ADMIN", "SCIENTIFIC") // Admin and Scientific access
                        .requestMatchers(HttpMethod.GET, "/scientific/**").hasRole("SCIENTIFIC") // Scientific community access
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                );

        return http.build(); // Ensure to return the HttpSecurity object
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager(); // Use the new AuthenticationManager
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
    }

    // Remove the @Bean annotation from this method
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser ("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN")
                .and()
                .withUser ("scientist").password(passwordEncoder().encode("scientistPass")).roles("SCIENTIFIC");
    }
}