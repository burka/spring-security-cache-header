package com.example.cachingheaderbug;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebFluxSecurity
public class WebSecurityConfiguration {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange(customizer -> customizer
                        .pathMatchers("/secured").authenticated()
                        .pathMatchers("/hello/mono", "/hello/string").permitAll()
                        .anyExchange().permitAll());
        return http.build();
    }
}
