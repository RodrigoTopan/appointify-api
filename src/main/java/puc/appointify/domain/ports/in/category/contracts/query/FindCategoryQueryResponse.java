package puc.appointify.domain.ports.in.category.contracts.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import puc.appointify.domain.ports.in.category.contracts.CompanyDTO;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FindCategoryQueryResponse {
    private UUID id;
    private String name;
    private List<CompanyDTO> companies;
}

