package puc.appointify.domain.ports.in.category.contracts.query;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FindCategoryQueryResponse {
    @NotNull
    private UUID id;
    @NotEmpty
    private String name;
}

