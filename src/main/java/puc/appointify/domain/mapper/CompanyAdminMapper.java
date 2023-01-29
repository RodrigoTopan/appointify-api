package puc.appointify.domain.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.command.company.CreateCompanyAdminCommand;
import puc.appointify.domain.command.company.CreateCompanyAdminResponse;
import puc.appointify.domain.command.company.FindCompanyAdminResponse;
import puc.appointify.domain.command.company.dto.CompanyDTO;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;

@Component
public class CompanyAdminMapper {
    public Company createCompanyAdminCommandToCompanyAdmin(CreateCompanyAdminCommand command) {
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

    public CreateCompanyAdminResponse companyAdminToCreateCompanyAdminResponse(Company company) {
        return CreateCompanyAdminResponse
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

    public FindCompanyAdminResponse companyAdminToFindCompanyAdminResponse(Company company) {
        return FindCompanyAdminResponse
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
