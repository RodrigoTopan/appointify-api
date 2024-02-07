package puc.appointify.gateway.database.mapper.impl;

import puc.appointify.domain.core.entity.OfferedService;
import puc.appointify.domain.core.entity.valueobject.Money;
import puc.appointify.gateway.database.entity.OfferedServiceEntity;

public class OfferedServiceDataAccessMapper {

    public static OfferedServiceEntity toEntity(OfferedService domain) {
        if (domain == null) return null;
        var company = domain.getCompany();
        var companyEntity = CompanyDataAccessMapper.toEntity(company);

        return OfferedServiceEntity
                .builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .price(domain.getPrice().getAmount())
                .company(companyEntity)
                .build();
    }

    public static OfferedService toDomain(OfferedServiceEntity entity) {
        if (entity == null) return null;
        var company = CompanyDataAccessMapper.toDomain(entity.getCompany());
        return new OfferedService(entity.getId(), company, entity.getName(), entity.getDescription(), new Money(entity.getPrice()));
    }
}
