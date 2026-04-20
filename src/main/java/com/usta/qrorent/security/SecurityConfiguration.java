//package com.usta.qrorent.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**", "/h2-console/**").permitAll()
//                        .requestMatchers("/", "/index", "/home", "/login", "/registro", "/register",
//                                "/nosotros", "/servicios", "/contacto", "/error").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/", true)
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/login?logout")
//                        .permitAll()
//                )
//                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
//                .csrf(csrf -> csrf
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                        .ignoringRequestMatchers("/h2-console/**")
//                );
//
//        return http.build();
//    }
//}