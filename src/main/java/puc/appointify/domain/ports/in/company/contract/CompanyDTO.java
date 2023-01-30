package puc.appointify.domain.ports.in.company.contract;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CompanyDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private String governmentId;
}

