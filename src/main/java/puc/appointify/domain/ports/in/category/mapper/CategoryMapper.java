package puc.appointify.domain.ports.in.category.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Category;
import puc.appointify.domain.ports.in.category.dto.Company;
import puc.appointify.domain.ports.in.category.dto.command.CreateCategoryCommand;
import puc.appointify.domain.ports.in.category.dto.command.CreateCategoryCommandResponse;
import puc.appointify.domain.ports.in.category.dto.query.FindCategoryQueryResponse;

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
                        .map(company -> new Company(company.getId(), company.getCompanyDetails().getName(),
                                company.getCompanyDetails().getDescription()))
                        .collect(Collectors.toList()))
                .build();
    }
}
