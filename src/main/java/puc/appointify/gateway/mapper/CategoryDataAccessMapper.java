package puc.appointify.gateway.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Category;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;
import puc.appointify.gateway.entity.CategoryEntity;
import puc.appointify.gateway.entity.CompanyEntity;

@Component
public class CategoryDataAccessMapper {
    public CategoryEntity toEntity(Category category) {
        if(category == null) return null;
        return CategoryEntity
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public Category toDomain(CategoryEntity entity) {
        if(entity == null) return null;
        var domain = Category
                .builder()
                .name(entity.getName())
                .build();
        domain.setId(entity.getId());
        return domain;
    }
}
