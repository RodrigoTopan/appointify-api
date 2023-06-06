package puc.appointify.application.rest.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationResponseDTO {
    private String token;
    private String username;
    private String role;
}
