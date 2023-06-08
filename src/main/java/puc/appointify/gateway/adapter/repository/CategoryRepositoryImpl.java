package puc.appointify.gateway.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Category;
import puc.appointify.domain.core.ports.out.repository.CategoryRepository;
import puc.appointify.gateway.database.entity.CategoryEntity;
import puc.appointify.gateway.database.jpa.CategoryJpaRepository;
import puc.appointify.gateway.database.mapper.DataMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {
    private final DataMapper<Category, CategoryEntity> mapper;
    private final CategoryJpaRepository jpaRepository;

    @Override
    public Category save(Category domain) {
        var entity = mapper.toEntity(domain);
        var savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public List<Category> findAll() {
        List<CategoryEntity> entities = jpaRepository.findAll();
        return entities
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Category> findAllById(List<UUID> ids) {
        List<CategoryEntity> entities = jpaRepository.findAllById(ids);
        return entities
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Category findById(UUID id) {
        var entity = jpaRepository.findById(id).orElse(null);
        if (entity == null) return null;
        return mapper.toDomain(entity);
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
