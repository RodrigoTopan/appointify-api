package puc.appointify.domain.core.ports.in.category.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.ports.in.category.contract.command.CreateCategoryCommand;
import puc.appointify.domain.core.ports.in.category.contract.command.CreateCategoryCommandResponse;
import puc.appointify.domain.core.ports.in.category.mapper.CategoryMapper;
import puc.appointify.domain.core.ports.out.repository.CategoryRepository;
import puc.appointify.domain.core.ports.in.category.CategoryCommandHandler;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CategoryCommandHandlerImpl implements CategoryCommandHandler {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public CreateCategoryCommandResponse create(CreateCategoryCommand command) {
        var category = categoryMapper.createCategoryCommandToCategory(command);
        var savedCategory = categoryRepository.save(category);
        return categoryMapper.categoryToCreateCategoryCommandResponse(savedCategory);
    }

    @Override
    public void deleteById(UUID id) {
        categoryRepository.deleteById(id);
    }

}
