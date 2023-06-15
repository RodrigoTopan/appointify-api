package puc.appointify.domain.core.ports.in.schedules.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
}
