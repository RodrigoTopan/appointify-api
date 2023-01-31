package puc.appointify.domain.ports.in.category.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.mapper.CategoryMapper;
import puc.appointify.domain.ports.in.category.CategoryCommandHandler;
import puc.appointify.domain.ports.in.category.contracts.command.CreateCategoryCommand;
import puc.appointify.domain.ports.in.category.contracts.command.CreateCategoryCommandResponse;
import puc.appointify.domain.ports.out.repository.CategoryRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CategoryCommandHandlerImpl implements CategoryCommandHandler {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public CreateCategoryCommandResponse create(CreateCategoryCommand command) {
        var category = categoryMapper.createCategoryCommandToCategory(command);
        category.initialize();
        var savedCategory = categoryRepository.save(category);
        return categoryMapper.categoryToCreateCategoryCommandResponse(savedCategory);
    }

    @Override
    public void deleteById(UUID id) {
        categoryRepository.deleteById(id);
    }

}
