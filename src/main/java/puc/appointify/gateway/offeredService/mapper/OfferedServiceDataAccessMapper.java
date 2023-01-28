package puc.appointify.gateway.offeredService.mapper;

import lombok.val;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.CompanyAdmin;
import puc.appointify.domain.core.entity.OfferedService;
import puc.appointify.domain.core.entity.valueobject.Company;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Money;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.company.entity.CompanyAdminEntity;
import puc.appointify.gateway.offeredService.entity.OfferedServiceEntity;

@Component
public class OfferedServiceDataAccessMapper {
    public OfferedServiceEntity toEntity(OfferedService domain) {
        var companyAdmin = domain.getCompanyAdmin();
        var company = companyAdmin.getCompany();

        var companyAdminEntity = CompanyAdminEntity
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
                .companyAdmin(CompanyAdmin
                        .builder()
                        .company(new Company(
                                companyAdmin.getCompanyName(),
                                companyAdmin.getCompanyDescription(),
                                companyAdmin.getCompanyGovernmentId()))
                        .build())
                .price(new Money(entity.getPrice()))
                .build();

        domain.setId(entity.getId());
        domain.getCompanyAdmin().setId(companyAdmin.getId());

        return domain;
    }
}
