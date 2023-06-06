package puc.appointify.gateway.database.mapper.impl;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Category;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.entity.User;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.database.entity.CategoryEntity;
import puc.appointify.gateway.database.entity.CompanyEntity;
import puc.appointify.gateway.database.mapper.DataMapper;

import java.util.stream.Collectors;

@Component
class CategoryDataAccessMapper implements DataMapper<Category, CategoryEntity> {

    public CategoryEntity toEntity(Category category) {
        if (category == null) return null;
        return CategoryEntity
                .builder()
                .id(category.getId())
                .name(category.getName())
                .image(category.getImage())
                .build();
    }

    public Category toDomain(CategoryEntity entity) {
        if (entity == null) return null;
        var domain = Category
                .builder()
                .name(entity.getName())
                .image(entity.getImage())
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

        var userEntity = entity.getUser();
        User user = null;

        if(userEntity != null) {
            user = User
                    .builder()
                    .email(new Email(userEntity.getEmail()))
                    .username(new Username(userEntity.getUsername()))
                    .build();
            user.setId(userEntity.getId());
        }

        var domain = Company
                .builder()
                .user(user)
                .companyDetails(new CompanyDetails(
                        entity.getCompanyName(),
                        entity.getCompanyDescription(),
                        entity.getCompanyGovernmentId()))
                .build();
        domain.setId(entity.getId());
        return domain;
    }
}
