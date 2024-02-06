package puc.appointify.gateway.database.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Category;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.entity.User;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.database.entity.CategoryEntity;
import puc.appointify.gateway.database.entity.CompanyEntity;
import puc.appointify.gateway.database.entity.UserEntity;
import puc.appointify.gateway.database.mapper.DataMapper;

import java.util.ArrayList;
import java.util.stream.Collectors;

import puc.appointify.domain.core.entity.valueobject.UserRole;

@Component
@RequiredArgsConstructor
class CategoryDataAccessMapper implements DataMapper<Category, CategoryEntity> {
    private final DataMapper<Company, CompanyEntity> companyEntityDataMapper;

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

        var entityCompanies = entity.getCompanies();
        if (entityCompanies != null) {
            var companies = entity.getCompanies()
                    .stream()
                    .map(companyEntityDataMapper::toDomain)
                    .collect(Collectors.toList());

            return new Category(entity.getId(), entity.getName(), entity.getImage(), companies);
        }

        return new Category(entity.getId(), entity.getName(), entity.getImage(), new ArrayList<>());
    }
}
