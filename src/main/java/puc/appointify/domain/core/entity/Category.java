package puc.appointify.domain.core.entity;

import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.core.common.entity.AggregateRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class Category extends AggregateRoot<UUID> {
    private String name;

    private final List<Company> companies = new ArrayList<>();

    public void initialize() {
        setId(UUID.randomUUID());
    }

    public void loadCompanies(List<Company> companies) {
        this.companies.addAll(companies);
    }

}
