package puc.appointify.domain.ports.in.customer.dto.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCustomerCommandResponse {

    private UUID id;
    private UUID userId;
}
