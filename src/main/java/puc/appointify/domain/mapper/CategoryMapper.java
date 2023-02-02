package puc.appointify.domain.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.common.entity.BaseEntity;
import puc.appointify.domain.core.entity.Category;
import puc.appointify.domain.ports.in.category.contracts.CompanyDTO;
import puc.appointify.domain.ports.in.category.contracts.command.CreateCategoryCommand;
import puc.appointify.domain.ports.in.category.contracts.command.CreateCategoryCommandResponse;
import puc.appointify.domain.ports.in.category.contracts.query.FindCategoryQueryResponse;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    public Category createCategoryCommandToCategory(CreateCategoryCommand command) {
        return Category
                .builder()
                .name(command.getName())
                .build();
    }

    public CreateCategoryCommandResponse categoryToCreateCategoryCommandResponse(Category category) {
        return CreateCategoryCommandResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public FindCategoryQueryResponse categoryToFindCategoryQueryResponse(Category category) {
        return FindCategoryQueryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .companies(category.getCompanies()
                        .stream()
                        .map(company -> new CompanyDTO(company.getId(), company.getCompanyDetails().getName(),
                                company.getCompanyDetails().getDescription()))
                        .collect(Collectors.toList()))
                .build();
    }
}
