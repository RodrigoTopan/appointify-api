package puc.appointify.gateway.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Category;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.entity.CategoryEntity;
import puc.appointify.gateway.entity.CompanyEntity;
import puc.appointify.gateway.mapper.DataMapper;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryDataAccessMapper implements DataMapper<Category, CategoryEntity> {

    public CategoryEntity toEntity(Category category) {
        if (category == null) return null;
        return CategoryEntity
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public Category toDomain(CategoryEntity entity) {
        if (entity == null) return null;
        var domain = Category
                .builder()
                .name(entity.getName())
                .build();
        domain.setId(entity.getId());

        var entityCompanies = entity.getCompanies();
        if (entityCompanies != null) {
            var companies = entity.getCompanies()
                    .stream()
                    .map(this::toDomain)
                    .collect(Collectors.toList());
            domain.loadCompanies(companies);
        }

        return domain;
    }

    private Company toDomain(CompanyEntity entity) {
        if (entity == null) return null;

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
