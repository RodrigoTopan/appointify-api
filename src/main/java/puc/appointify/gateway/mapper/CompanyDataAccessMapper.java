package puc.appointify.gateway.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.entity.CompanyEntity;

@Component
public class CompanyDataAccessMapper {
    public CompanyEntity toEntity(Company company) {
        return CompanyEntity
                .builder()
                .id(company.getId())
                .email(company.getEmail().getValue())
                .name(company.getName().getValue())
                .password(company.getPassword().getValue())
                .companyName(company.getCompanyDetails().getName())
                .companyDescription(company.getCompanyDetails().getDescription())
                .companyGovernmentId(company.getCompanyDetails().getGovernmentId())
                .build();
    }

    public Company toDomain(CompanyEntity entity) {
        var domain = Company
                .builder()
                .email(new Email(entity.getEmail()))
                .name(new Username(entity.getName()))
                .password(new Password(entity.getPassword()))
                .companyDetails(new CompanyDetails(
                        entity.getCompanyName(),
                        entity.getCompanyDescription(),
                        entity.getCompanyGovernmentId()))
                .build();
        domain.setId(entity.getId());
        return domain;
    }
}
