package puc.appointify.domain.ports.in.company.dto.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.ports.in.company.dto.Category;
import puc.appointify.domain.ports.in.company.dto.Company;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCompanyCommandResponse {

    private UUID id;
    private UUID userId;
    private Company company;
    private List<Category> categories;
}
