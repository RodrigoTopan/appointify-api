package puc.appointify.domain.ports.in.customer.contract.command;

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
public class CreateCustomerCommand {
    @NotNull
    private UUID userId;
}
