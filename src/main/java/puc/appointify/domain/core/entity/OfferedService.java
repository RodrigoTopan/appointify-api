package puc.appointify.domain.core.entity;

import puc.appointify.domain.core.common.entity.BaseEntity;
import puc.appointify.domain.core.entity.valueobject.Money;

import java.util.UUID;

public class OfferedService extends BaseEntity<UUID> {

    private final Company company;
    private final String name;
    private final String description;
    private final Money price;

    public OfferedService(Company company, String name, String description, Money price) {
        super(UUID.randomUUID());
        this.company = company;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public OfferedService(UUID id, Company company, String name, String description, Money price) {
        super(id);
        this.company = company;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Money getPrice() {
        return price;
    }
}
