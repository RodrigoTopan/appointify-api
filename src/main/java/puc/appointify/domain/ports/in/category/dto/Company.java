package puc.appointify.domain.ports.in.category.dto;

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
public class Company {

    private UUID id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
}

