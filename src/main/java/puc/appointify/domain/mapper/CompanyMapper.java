package puc.appointify.domain.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.domain.ports.in.company.contract.CategoryDTO;
import puc.appointify.domain.ports.in.company.contract.CompanyDTO;
import puc.appointify.domain.ports.in.company.contract.command.CreateCompanyCommand;
import puc.appointify.domain.ports.in.company.contract.command.CreateCompanyCommandResponse;
import puc.appointify.domain.ports.in.company.contract.query.FindCompanyQueryResponse;

import java.util.stream.Collectors;

@Component
public class CompanyMapper {
    public Company createCompanyCommandToCompany(CreateCompanyCommand command) {
        return Company
                .builder()
                .email(new Email(command.getEmail()))
                .name(new Username(command.getName()))
                .password(new Password(command.getPassword()))
                .companyDetails(new CompanyDetails(
                        command.getCompany().getName(),
                        command.getCompany().getDescription(),
                        command.getCompany().getGovernmentId()))
                .build();
    }

    public CreateCompanyCommandResponse companyToCreateCompanyCommandResponse(Company company) {
        var categories = company.getCategories()
                .stream()
                .map(category -> new CategoryDTO(category.getId(), category.getName()))
                .collect(Collectors.toList());

        return CreateCompanyCommandResponse
                .builder()
                .id(company.getId())
                .email(company.getEmail().getValue())
                .name(company.getName().getValue())
                .password(company.getPassword().getValue())
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
                .email(company.getEmail().getValue())
                .name(company.getName().getValue())
                .password(company.getPassword().getValue())
                .company(CompanyDTO.builder()
                        .name(company.getCompanyDetails().getName())
                        .description(company.getCompanyDetails().getDescription())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .build())
                .build();
    }
}
