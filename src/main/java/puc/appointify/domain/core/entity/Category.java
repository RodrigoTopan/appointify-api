package puc.appointify.domain.core.entity;

import puc.appointify.domain.core.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Category extends BaseEntity<UUID> {
    private final String name;
    private final String image;

    private final List<Company> companies = new ArrayList<>();

    public Category(String name, String image) {
        super(UUID.randomUUID());
        this.name = name;
        this.image = image;
    }

    public Category(UUID id, String name, String image, List<Company> companies) {
        super(id);
        this.name = name;
        this.image = image;
        this.companies.addAll(companies);
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
