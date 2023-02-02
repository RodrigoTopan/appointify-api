package puc.appointify.domain.ports.in.user.contracts.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import puc.appointify.domain.core.entity.valueobject.UserRole;
import puc.appointify.domain.ports.in.user.contracts.UserRoleDTO;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateUserCommand {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String username;
    @Email
    private String email;
    @NotEmpty
    private String password;

    @NotNull
    private UserRole role;
}

