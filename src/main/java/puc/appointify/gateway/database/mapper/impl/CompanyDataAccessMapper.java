package puc.appointify.gateway.database.mapper.impl;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Category;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.entity.User;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.UserRole;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.database.entity.CategoryEntity;
import puc.appointify.gateway.database.entity.UserEntity;
import puc.appointify.gateway.database.mapper.DataMapper;
import puc.appointify.gateway.database.entity.CompanyEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
class CompanyDataAccessMapper implements DataMapper<Company, CompanyEntity> {

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
                .user(UserEntity
                        .builder()
                        .id(company.getUser().getId())
                        .firstName(company.getUser().getFirstName())
                        .lastName(company.getUser().getLastName())
                        .username(company.getUser().getUsername().getValue())
                        .email(company.getUser().getEmail().getValue())
                        .role(company.getUser().getRole().getValue())
                        .build())
                .companyName(company.getCompanyDetails().getName())
                .companyDescription(company.getCompanyDetails().getDescription())
                .companyGovernmentId(company.getCompanyDetails().getGovernmentId())
                .companyImage(company.getCompanyDetails().getImage())
                .categories(categoriesEntities)
                .build();
    }

    public Company toDomain(CompanyEntity entity) {
        if (entity == null) return null;

        var userEntity = entity.getUser();
        var user = User
                .builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(new Email(userEntity.getEmail()))
                .username(new Username(userEntity.getUsername()))
                .password(new Password(userEntity.getPassword()))
                .role(UserRole.valueOf(userEntity.getRole()))
                .build();
        user.setId(userEntity.getId());

        var domain = Company
                .builder()
                .user(user)
                .companyDetails(new CompanyDetails(
                        entity.getCompanyName(),
                        entity.getCompanyDescription(),
                        entity.getCompanyGovernmentId(),
                        entity.getCompanyImage()))
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
