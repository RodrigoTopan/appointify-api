package puc.appointify.domain.core.ports.in.category.contract;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

    private UUID id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    private String image;
}

