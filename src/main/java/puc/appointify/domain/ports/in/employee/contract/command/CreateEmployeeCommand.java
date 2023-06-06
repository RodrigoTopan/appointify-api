package puc.appointify.domain.ports.in.employee.contract.command;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeCommand {
    @NotNull
    private UUID userId;
    @NotNull
    private UUID companyId;
}

