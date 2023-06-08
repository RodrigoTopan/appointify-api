package puc.appointify.gateway.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Company;
import puc.appointify.domain.core.ports.out.repository.CompanyRepository;
import puc.appointify.gateway.database.entity.CompanyEntity;
import puc.appointify.gateway.database.jpa.CompanyJpaRepository;
import puc.appointify.gateway.database.mapper.DataMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {
    private final DataMapper<Company, CompanyEntity> mapper;
    private final CompanyJpaRepository jpaRepository;

    @Override
    public Company save(Company domain) {
        var entity = mapper.toEntity(domain);
        var savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public List<Company> findAll() {
        List<CompanyEntity> entities = jpaRepository.findAll();
        return entities
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Company findById(UUID id) {
        var entity = jpaRepository.findById(id).orElse(null);
        if (entity == null) return null;
        return mapper.toDomain(entity);
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
