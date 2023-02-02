package puc.appointify.application.rest.security.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationDTO {
    private String username;
    private String password;
}
