package puc.appointify.domain.ports.in.employee.contract.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateEmployeeCommand {
    @NotEmpty
    private String name;
    @Email
    private String email;
    @NotEmpty
    private String password;
    @NotNull
    private UUID companyId;
}

