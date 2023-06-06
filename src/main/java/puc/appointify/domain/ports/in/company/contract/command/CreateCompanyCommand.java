package puc.appointify.domain.ports.in.company.contract.command;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import puc.appointify.domain.ports.in.company.contract.CompanyDTO;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyCommand {
    @NotNull
    private UUID userId;
    @Valid
    private CompanyDTO company;

    private List<UUID> categories;
}

