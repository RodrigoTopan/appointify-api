package puc.appointify.domain.core.ports.in.category.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.ports.in.category.contract.query.FindCategoryQueryResponse;
import puc.appointify.domain.core.ports.in.category.mapper.CategoryMapper;
import puc.appointify.domain.core.ports.out.repository.CategoryRepository;
import puc.appointify.domain.core.ports.in.category.CategoryQueryHandler;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryQueryHandlerImpl implements CategoryQueryHandler {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;


    @Override
    public List<FindCategoryQueryResponse> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToFindCategoryQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FindCategoryQueryResponse findById(UUID id) {
        var category = categoryRepository.findById(id);
        return categoryMapper.categoryToFindCategoryQueryResponse(category);
    }
}
