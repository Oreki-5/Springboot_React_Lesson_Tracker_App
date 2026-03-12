package com.Oreki.Lesson_Tracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Oreki.Lesson_Tracker.Service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JWTAuthorizationConfig jwtAuthorizationConfig;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(e -> e.disable());
        http.authorizeHttpRequests(request -> {
            request.requestMatchers("/**/verify","/**/register","/login").permitAll();
            request.requestMatchers("/users/**").hasRole("USER");
            // request.requestMatchers("/admin/**").hasRole("ADMIN");
            request.anyRequest().authenticated();

        });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        http.cors(c->c.disable());
        http.addFilterBefore(jwtAuthorizationConfig, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }

    @Autowired
    MyUserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        return provider;

    }

    @Bean
    public AuthenticationManager myAuthenticationManager(AuthenticationConfiguration configuration){
        return configuration.getAuthenticationManager();
    }

    // @Bean
    // CorsConfigurationSource corsConfigurationSource() {
    // CorsConfiguration configuration = new CorsConfiguration();

    // configuration.setAllowedOrigins(Collections.singletonList("http://localhost:5173"));
    // configuration.setAllowedHeaders(List.of("*"));
    // configuration.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS"));
    // configuration.setAllowCredentials(true);

    // UrlBasedCorsConfigurationSource source = new
    // UrlBasedCorsConfigurationSource();
    // source.registerCorsConfiguration("/**", configuration);

    // return source;
    // }
    // @Bean
    // public PasswordEncoder passwordEncoder() {
    // return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    // }

    // @Bean
    // public UserDetailsService userDetailsService(){
    // InMemoryUserDetailsManager myUserDetailsManager = new
    // InMemoryUserDetailsManager();

    // }
}
