package puc.appointify.domain.ports.in.company.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.ports.in.company.contract.CategoryDTO;
import puc.appointify.domain.ports.in.company.contract.CompanyDTO;
import puc.appointify.domain.ports.in.company.contract.command.CreateCompanyCommandResponse;
import puc.appointify.domain.ports.in.company.contract.query.FindCompanyQueryResponse;

import java.util.stream.Collectors;

@Component
public class CompanyMapper {

    public CreateCompanyCommandResponse companyToCreateCompanyCommandResponse(Company company) {
        var categories = company.getCategories()
                .stream()
                .map(category -> new CategoryDTO(category.getId(), category.getName()))
                .collect(Collectors.toList());

        return CreateCompanyCommandResponse
                .builder()
                .id(company.getId())
                .userId(company.getUser().getId())
                .company(CompanyDTO.builder()
                        .name(company.getCompanyDetails().getName())
                        .description(company.getCompanyDetails().getDescription())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .build())
                .categories(categories)
                .build();
    }

    public FindCompanyQueryResponse companyToFindCompanyQueryResponse(Company company) {
        return FindCompanyQueryResponse
                .builder()
                .id(company.getId())
                .userId(company.getUser().getId())
                .company(CompanyDTO.builder()
                        .name(company.getCompanyDetails().getName())
                        .description(company.getCompanyDetails().getDescription())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .build())
                .build();
    }
}
