package puc.appointify.application.rest.security.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.user.UserQueryHandler;
import puc.appointify.domain.ports.in.user.contracts.query.FindUserQuery;
import puc.appointify.domain.ports.in.user.contracts.query.FindUserQueryResponse;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserQueryHandler userQueryHandler;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final FindUserQueryResponse userQueryResponse = userQueryHandler
                .find(FindUserQuery
                        .builder()
                        .username(username)
                        .build());

        return UserDetailsImpl
                .builder()
                .username(userQueryResponse.getUsername())
                .password(userQueryResponse.getPassword())
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .authorities(List.of(new SimpleGrantedAuthority("admin")))
                .build();
    }
}
