package puc.appointify.domain.command.offeredservice;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
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
public class CreateOfferedServiceCommand {
    @NotNull
    private UUID companyAdminId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;

    @PositiveOrZero
    private BigDecimal price;
}

