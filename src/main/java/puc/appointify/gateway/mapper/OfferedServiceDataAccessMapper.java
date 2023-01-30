package puc.appointify.gateway.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.entity.OfferedService;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.entity.valueobject.Money;
import puc.appointify.gateway.entity.CompanyEntity;
import puc.appointify.gateway.entity.OfferedServiceEntity;

@Component
public class OfferedServiceDataAccessMapper {
    public OfferedServiceEntity toEntity(OfferedService domain) {
        var companyAdmin = domain.getCompany();
        var company = companyAdmin.getCompanyDetails();

        var companyAdminEntity = CompanyEntity
                .builder()
                .id(companyAdmin.getId())
                .name(companyAdmin.getName().getValue())
                .email(companyAdmin.getEmail().getValue())
                .password(companyAdmin.getPassword().getValue())
                .companyName(company.getName())
                .companyDescription(company.getDescription())
                .companyGovernmentId(company.getGovernmentId())
                .build();

        return OfferedServiceEntity
                .builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .price(domain.getPrice().getAmount())
                .companyAdmin(companyAdminEntity)
                .build();
    }

    public OfferedService toDomain(OfferedServiceEntity entity) {
        var companyAdmin = entity.getCompanyAdmin();
        var domain = OfferedService
                .builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .company(Company
                        .builder()
                        .companyDetails(new CompanyDetails(
                                companyAdmin.getCompanyName(),
                                companyAdmin.getCompanyDescription(),
                                companyAdmin.getCompanyGovernmentId()))
                        .build())
                .price(new Money(entity.getPrice()))
                .build();

        domain.setId(entity.getId());
        domain.getCompany().setId(companyAdmin.getId());

        return domain;
    }
}
