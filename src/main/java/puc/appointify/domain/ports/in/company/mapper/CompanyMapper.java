package puc.appointify.domain.ports.in.company.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.company.dto.Category;
import puc.appointify.domain.ports.in.company.dto.Company;
import puc.appointify.domain.ports.in.company.dto.command.CreateCompanyCommandResponse;
import puc.appointify.domain.ports.in.company.dto.query.FindCompanyQueryResponse;

import java.util.stream.Collectors;

@Component
public class CompanyMapper {

    public CreateCompanyCommandResponse companyToCreateCompanyCommandResponse(puc.appointify.domain.core.entity.Company company) {
        var categories = company.getCategories()
                .stream()
                .map(category -> new Category(category.getId(), category.getName()))
                .collect(Collectors.toList());

        return CreateCompanyCommandResponse
                .builder()
                .id(company.getId())
                .userId(company.getUser().getId())
                .company(Company.builder()
                        .name(company.getCompanyDetails().getName())
                        .description(company.getCompanyDetails().getDescription())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .build())
                .categories(categories)
                .build();
    }

    public FindCompanyQueryResponse companyToFindCompanyQueryResponse(puc.appointify.domain.core.entity.Company company) {
        return FindCompanyQueryResponse
                .builder()
                .id(company.getId())
                .userId(company.getUser().getId())
                .company(Company.builder()
                        .name(company.getCompanyDetails().getName())
                        .description(company.getCompanyDetails().getDescription())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .build())
                .build();
    }
}
