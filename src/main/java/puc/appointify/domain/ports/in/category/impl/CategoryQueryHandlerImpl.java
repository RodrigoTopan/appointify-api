package puc.appointify.domain.ports.in.category.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.category.mapper.CategoryMapper;
import puc.appointify.domain.ports.in.category.CategoryQueryHandler;
import puc.appointify.domain.ports.in.category.dto.query.FindCategoryQueryResponse;
import puc.appointify.domain.ports.out.repository.CategoryRepository;

import java.util.List;
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
}
