package puc.appointify.gateway.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.OfferedService;
import puc.appointify.domain.core.ports.out.repository.OfferedServiceRepository;
import puc.appointify.gateway.database.entity.OfferedServiceEntity;
import puc.appointify.gateway.database.jpa.OfferedServiceJpaRepository;
import puc.appointify.gateway.database.mapper.DataMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OfferedServiceRepositoryImpl implements OfferedServiceRepository {
    private final DataMapper<OfferedService, OfferedServiceEntity> mapper;
    private final OfferedServiceJpaRepository jpaRepository;

    @Override
    public OfferedService save(OfferedService domain) {
        var entity = mapper.toEntity(domain);
        var savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public List<OfferedService> findAll() {
        List<OfferedServiceEntity> entities = jpaRepository.findAll();
        return entities
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public OfferedService findById(UUID id) {
        var entity = jpaRepository.findById(id).orElseThrow();
        return mapper.toDomain(entity);
    }

    @Override
    public List<OfferedService> findAllByCompanyId(UUID companyId) {
        List<OfferedServiceEntity> entities = jpaRepository.findAllByCompanyId(companyId);
        return entities
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
