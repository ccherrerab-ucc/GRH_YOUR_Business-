package com.tuempresa.rrhh.frameworksdrivers.config_security;

//import com.tuempresa.rrhh.filter.JwtRequestFilter;
//import com.tuempresa.rrhh.application.service.auth.CustomUserDetailsService;
import com.tuempresa.rrhh.frameworksdrivers.config_security.filter.JwtAuthenticationFilter;
//import com.tuempresa.rrhh.security.UserDetailsServiceImpl;
import com.tuempresa.rrhh.infrastructure.persintence.repository.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter JwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;
    private final UserDetailsServiceImpl userDetailsService;

    //private CustomUserDetailsService userDetailsService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf ->
                csrf
                .disable())
                .authorizeHttpRequests(
                        authRequest  -> authRequest
                                .requestMatchers("/auth/**").permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(
                        sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(JwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }


}