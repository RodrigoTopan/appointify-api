package puc.appointify.gateway.company.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.CompanyAdmin;
import puc.appointify.domain.ports.out.repository.CompanyAdminRepository;
import puc.appointify.gateway.company.entity.CompanyAdminEntity;
import puc.appointify.gateway.company.jpa.CompanyAdminJpaRepository;
import puc.appointify.gateway.company.mapper.CompanyAdminDataAccessMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyAdminRepositoryImpl implements CompanyAdminRepository {
    private final CompanyAdminDataAccessMapper mapper;
    private final CompanyAdminJpaRepository jpaRepository;
    @Override
    public CompanyAdmin save(CompanyAdmin domain) {
        var entity = mapper.toEntity(domain);
        var savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public List<CompanyAdmin> findAll() {
        List<CompanyAdminEntity> entities = jpaRepository.findAll();
        return entities
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyAdmin findById(UUID id) {
        var entity = jpaRepository.findById(id).orElse(null);
        if(entity == null) return null;
        return mapper.toDomain(entity);
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
