package puc.appointify.domain.core.ports.in.user.contract.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserCommandResponse {

    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
}
