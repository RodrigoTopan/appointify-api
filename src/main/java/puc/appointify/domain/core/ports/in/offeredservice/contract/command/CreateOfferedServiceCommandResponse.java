package puc.appointify.domain.core.ports.in.offeredservice.contract.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOfferedServiceCommandResponse {
    private UUID id;
    private UUID companyId;
    private String name;
    private String description;
    private BigDecimal price;
}

