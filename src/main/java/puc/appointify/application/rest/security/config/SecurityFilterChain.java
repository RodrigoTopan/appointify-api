package puc.appointify.application.rest.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import puc.appointify.application.rest.security.filter.JwtRequestFilter;
import puc.appointify.application.rest.security.impl.UserDetailsServiceImpl;
import puc.appointify.application.rest.security.util.JwtTokenUtil;

@Configuration
public class SecurityFilterChain {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthenticationManager authenticationManager;


    @Bean
    public org.springframework.security.web.SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/h2-console/*").permitAll()
                .requestMatchers("/users/*").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilter(new JwtRequestFilter(authenticationManager, userDetailsService, jwtTokenUtil));
        return http.build();
    }

}
