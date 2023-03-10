package puc.appointify.domain.ports.in.category.contract;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CompanyDTO {

    private UUID id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
}

