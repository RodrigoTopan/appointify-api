package puc.appointify.domain.ports.in.category.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Category;
import puc.appointify.domain.ports.in.category.contract.CompanyDTO;
import puc.appointify.domain.ports.in.category.contract.command.CreateCategoryCommand;
import puc.appointify.domain.ports.in.category.contract.command.CreateCategoryCommandResponse;
import puc.appointify.domain.ports.in.category.contract.query.FindCategoryQueryResponse;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    public Category createCategoryCommandToCategory(CreateCategoryCommand command) {
        return Category
                .builder()
                .name(command.getName())
                .image(command.getImage())
                .build();
    }

    public CreateCategoryCommandResponse categoryToCreateCategoryCommandResponse(Category category) {
        return CreateCategoryCommandResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .image(category.getImage())
                .build();
    }

    public FindCategoryQueryResponse categoryToFindCategoryQueryResponse(Category category) {
        return FindCategoryQueryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .image(category.getImage())
                .companies(category.getCompanies()
                        .stream()
                        .map(company -> new CompanyDTO(company.getId(), company.getCompanyDetails().getName(),
                                company.getCompanyDetails().getDescription()))
                        .collect(Collectors.toList()))
                .build();
    }
}
