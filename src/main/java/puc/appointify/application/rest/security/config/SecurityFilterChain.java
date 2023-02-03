package puc.appointify.application.rest.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import puc.appointify.application.rest.security.filter.JwtRequestFilter;
import puc.appointify.application.rest.security.util.JwtTokenUtil;

@Configuration
@RequiredArgsConstructor
public class SecurityFilterChain {
    private final UserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;
    public final AuthenticationManager authenticationManager;


    @Bean
    public org.springframework.security.web.SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/actuator/health",
                        "/actuator/info",
                        "/swagger-resources/**",
                        "/v2/api-docs/**",
                        "/csrf/**",
                        "/webjars/**",
                        "/swagger-ui.html",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/users/*"
                ).permitAll()
                .anyRequest()
                .authenticated();

        http.addFilter(new JwtRequestFilter(authenticationManager, userDetailsService, jwtTokenUtil));
        return http.build();
    }

}
