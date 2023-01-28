package puc.appointify.domain.command.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateCustomerCommand {
    @NotEmpty
    private String name;
    @Email
    private String email;
    @NotEmpty
    private String password;
}
