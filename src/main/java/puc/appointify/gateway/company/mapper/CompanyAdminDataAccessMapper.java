package puc.appointify.gateway.company.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.CompanyAdmin;
import puc.appointify.domain.core.entity.valueobject.Company;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.company.entity.CompanyAdminEntity;

@Component
public class CompanyAdminDataAccessMapper {
    public CompanyAdminEntity toEntity(CompanyAdmin companyAdmin) {
        return CompanyAdminEntity
                .builder()
                .id(companyAdmin.getId())
                .email(companyAdmin.getEmail().getValue())
                .name(companyAdmin.getName().getValue())
                .password(companyAdmin.getPassword().getValue())
                .companyName(companyAdmin.getCompany().getName())
                .companyDescription(companyAdmin.getCompany().getDescription())
                .companyGovernmentId(companyAdmin.getCompany().getGovernmentId())
                .build();
    }

    public CompanyAdmin toDomain(CompanyAdminEntity entity) {
        var domain = CompanyAdmin
                .builder()
                .email(new Email(entity.getEmail()))
                .name(new Username(entity.getName()))
                .password(new Password(entity.getPassword()))
                .company(new Company(entity.getCompanyName(), entity.getCompanyDescription(), entity.getCompanyGovernmentId()))
                .build();
        domain.setId(entity.getId());
        return domain;
    }
}
