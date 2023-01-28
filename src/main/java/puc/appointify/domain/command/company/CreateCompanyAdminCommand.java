package puc.appointify.domain.command.company;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import puc.appointify.domain.command.company.dto.CompanyDTO;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateCompanyAdminCommand {
    @NotEmpty
    private String name;
    @Email
    private String email;
    @NotEmpty
    private String password;

    @Valid
    private CompanyDTO company;
}

