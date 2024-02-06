package puc.appointify.gateway.database.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.entity.OfferedService;
import puc.appointify.domain.core.entity.valueobject.Money;
import puc.appointify.gateway.database.entity.CompanyEntity;
import puc.appointify.gateway.database.entity.OfferedServiceEntity;
import puc.appointify.gateway.database.mapper.DataMapper;

@Component
@RequiredArgsConstructor
class OfferedServiceDataAccessMapper implements DataMapper<OfferedService, OfferedServiceEntity> {
    private final DataMapper<Company, CompanyEntity> companyDataAccessMapper;

    public OfferedServiceEntity toEntity(OfferedService domain) {
        if (domain == null) return null;
        var company = domain.getCompany();
        var companyEntity = companyDataAccessMapper.toEntity(company);

        return OfferedServiceEntity
                .builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .price(domain.getPrice().getAmount())
                .company(companyEntity)
                .build();
    }

    public OfferedService toDomain(OfferedServiceEntity entity) {
        if (entity == null) return null;
        var company = companyDataAccessMapper.toDomain(entity.getCompany());
        return new OfferedService(company, entity.getName(), entity.getDescription(), new Money(entity.getPrice()));
    }
}
