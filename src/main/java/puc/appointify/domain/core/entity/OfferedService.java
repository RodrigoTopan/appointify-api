package puc.appointify.domain.core.entity;

import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.common.entity.AggregateRoot;
import puc.appointify.domain.core.entity.valueobject.Money;

import java.util.UUID;

@Getter
@Builder
public class OfferedService extends AggregateRoot<UUID> {

    private CompanyAdmin companyAdmin;
    private String name;
    private String description;
    private Money price;

    public void initialize(CompanyAdmin companyAdmin) {
        setId(UUID.randomUUID());
        this.companyAdmin = companyAdmin;
    }
}
