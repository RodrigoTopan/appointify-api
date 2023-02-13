package puc.appointify.domain.ports.in.schedules.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class Service {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
}
