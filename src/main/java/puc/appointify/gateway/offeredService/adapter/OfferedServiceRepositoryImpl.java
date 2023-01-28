package puc.appointify.gateway.offeredService.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.OfferedService;
import puc.appointify.domain.ports.out.repository.OfferedServiceRepository;
import puc.appointify.gateway.offeredService.entity.OfferedServiceEntity;
import puc.appointify.gateway.offeredService.jpa.OfferedServiceJpaRepository;
import puc.appointify.gateway.offeredService.mapper.OfferedServiceDataAccessMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OfferedServiceRepositoryImpl implements OfferedServiceRepository {
    private final OfferedServiceDataAccessMapper mapper;
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
}
