//package com.jagt.employ.gateway.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@EnableWebFluxSecurity
//public class WebSecurityConfig {
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http
//                .csrf().disable()
//                .authorizeExchange()
//                .pathMatchers("/actuator/**")
//                .authenticated()
//                .anyExchange()
//                .permitAll()
//                .and()
//                .httpBasic();
//        return http.build();
//    }
//}