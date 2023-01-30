package puc.appointify.domain.ports.in.schedules.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ServiceDTO {
    private String name;
    private String description;
    private BigDecimal price;
}
