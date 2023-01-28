package puc.appointify.domain.command.offeredservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class OfferedServiceResponse {
    private UUID id;
    private UUID companyAdminId;
    private String name;
    private String description;
    private BigDecimal price;
}

