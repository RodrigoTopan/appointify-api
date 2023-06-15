package puc.appointify.domain.core.ports.in.category.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import puc.appointify.domain.core.ports.in.category.contract.CompanyDTO;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindCategoryQueryResponse {
    private UUID id;
    private String name;
    private String image;
    private List<CompanyDTO> companies;
}

