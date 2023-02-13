package puc.appointify.domain.ports.in.company.dto.command;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import puc.appointify.domain.ports.in.company.dto.Company;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateCompanyCommand {
    @NotNull
    private UUID userId;
    @Valid
    private Company company;

    private List<UUID> categories;
}

