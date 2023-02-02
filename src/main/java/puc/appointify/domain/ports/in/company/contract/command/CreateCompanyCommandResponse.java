package puc.appointify.domain.ports.in.company.contract.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.ports.in.company.contract.CategoryDTO;
import puc.appointify.domain.ports.in.company.contract.CompanyDTO;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCompanyCommandResponse {

    private UUID id;
    private UUID userId;
    private CompanyDTO company;
    private List<CategoryDTO> categories;
}
