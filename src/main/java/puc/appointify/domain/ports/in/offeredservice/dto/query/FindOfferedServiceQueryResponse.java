package puc.appointify.domain.ports.in.offeredservice.dto.query;

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
public class FindOfferedServiceQueryResponse {
    private UUID id;
    private UUID companyId;
    private String name;
    private String description;
    private BigDecimal price;
}

