//package com.inteswitchmiddleware.digitalmiddleware.config;
//
////import com.inteswitchmiddleware.digitalmiddleware.service.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
////    @Autowired
////    private  UserDetailsServiceImpl userDetailsService;
////    @Autowired
////    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
////    public SecurityConfig(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
////        this.userDetailsService = userDetailsService;
////        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
////    }
//
//    @Bean
//    SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        // Configure AuthenticationManagerBuilder
////        AuthenticationManagerBuilder authenticationManagerBuilder = http
////        .getSharedObject(AuthenticationManagerBuilder.class);
////        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//
//        http.csrf((csrf) -> csrf.disable()).authorizeHttpRequests(
//        (authz) -> authz.requestMatchers( "/login","/register","/h2-console/**")
//        .permitAll()
//        .anyRequest().authenticated())
//        .headers((headers)->headers.frameOptions((frameOptions)->frameOptions.disable()));
//
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//
//
//}
