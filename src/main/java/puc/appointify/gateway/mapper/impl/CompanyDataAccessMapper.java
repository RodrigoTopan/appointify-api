package puc.appointify.gateway.mapper.impl;

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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyDataAccessMapper implements DataMapper<Company, CompanyEntity> {

    public CompanyEntity toEntity(Company company) {
        if (company == null) return null;

        var companyCategories = company.getCategories();

        List<CategoryEntity> categoriesEntities = new ArrayList<>();
        if (companyCategories != null) {
            categoriesEntities.addAll(companyCategories
                    .stream()
                    .map(this::toEntity)
                    .toList());
        }

        return CompanyEntity
                .builder()
                .id(company.getId())
                .email(company.getEmail().getValue())
                .name(company.getName().getValue())
                .password(company.getPassword().getValue())
                .companyName(company.getCompanyDetails().getName())
                .companyDescription(company.getCompanyDetails().getDescription())
                .companyGovernmentId(company.getCompanyDetails().getGovernmentId())
                .categories(categoriesEntities)
                .build();
    }

    public Company toDomain(CompanyEntity entity) {
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

        var entityCategories = entity.getCategories();
        if (entityCategories != null) {
            var categories = entityCategories
                    .stream()
                    .map(this::toDomain)
                    .collect(Collectors.toList());
            domain.loadCategories(categories);
        }

        domain.setId(entity.getId());

        return domain;
    }


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
        return domain;
    }
}
