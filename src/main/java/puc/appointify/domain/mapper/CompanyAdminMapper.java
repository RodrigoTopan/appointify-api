package puc.appointify.domain.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.command.company.CreateCompanyAdminCommand;
import puc.appointify.domain.command.company.CreateCompanyAdminResponse;
import puc.appointify.domain.command.company.FindCompanyAdminResponse;
import puc.appointify.domain.command.company.dto.CompanyDTO;
import puc.appointify.domain.core.entity.CompanyAdmin;
import puc.appointify.domain.core.entity.valueobject.Company;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;

@Component
public class CompanyAdminMapper {
    public CompanyAdmin createCompanyAdminCommandToCompanyAdmin(CreateCompanyAdminCommand command) {
        return CompanyAdmin
                .builder()
                .email(new Email(command.getEmail()))
                .name(new Username(command.getName()))
                .password(new Password(command.getPassword()))
                .company(new Company(
                        command.getCompany().getName(),
                        command.getCompany().getDescription(),
                        command.getCompany().getGovernmentId()))
                .build();
    }

    public CreateCompanyAdminResponse companyAdminToCreateCompanyAdminResponse(CompanyAdmin companyAdmin) {
        return CreateCompanyAdminResponse
                .builder()
                .id(companyAdmin.getId())
                .email(companyAdmin.getEmail().getValue())
                .name(companyAdmin.getName().getValue())
                .password(companyAdmin.getPassword().getValue())
                .company(CompanyDTO.builder()
                        .name(companyAdmin.getCompany().getName())
                        .description(companyAdmin.getCompany().getDescription())
                        .governmentId(companyAdmin.getCompany().getGovernmentId())
                        .build())
                .build();
    }

    public FindCompanyAdminResponse companyAdminToFindCompanyAdminResponse(CompanyAdmin companyAdmin) {
        return FindCompanyAdminResponse
                .builder()
                .id(companyAdmin.getId())
                .email(companyAdmin.getEmail().getValue())
                .name(companyAdmin.getName().getValue())
                .password(companyAdmin.getPassword().getValue())
                .company(CompanyDTO.builder()
                        .name(companyAdmin.getCompany().getName())
                        .description(companyAdmin.getCompany().getDescription())
                        .governmentId(companyAdmin.getCompany().getGovernmentId())
                        .build())
                .build();
    }
}
