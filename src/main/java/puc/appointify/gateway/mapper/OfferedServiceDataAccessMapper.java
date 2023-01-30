package puc.appointify.gateway.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.entity.OfferedService;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.entity.valueobject.Money;
import puc.appointify.gateway.entity.CompanyEntity;
import puc.appointify.gateway.entity.OfferedServiceEntity;

@Component
@RequiredArgsConstructor
public class OfferedServiceDataAccessMapper {
    private final CompanyDataAccessMapper companyDataAccessMapper;

    public OfferedServiceEntity toEntity(OfferedService domain) {
        var companyAdmin = domain.getCompany();
        var companyAdminEntity = companyDataAccessMapper.toEntity(companyAdmin);

        return OfferedServiceEntity
                .builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .price(domain.getPrice().getAmount())
                .company(companyAdminEntity)
                .build();
    }

    public OfferedService toDomain(OfferedServiceEntity entity) {
        var companyAdmin = entity.getCompany();
        var domain = OfferedService
                .builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .company(companyDataAccessMapper.toDomain(entity.getCompany()))
                .price(new Money(entity.getPrice()))
                .build();

        domain.setId(entity.getId());
        domain.getCompany().setId(companyAdmin.getId());

        return domain;
    }
}
