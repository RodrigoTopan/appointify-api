package puc.appointify.domain.ports.in.company.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CategoryDTO {
    private UUID id;
    private String name;
}

