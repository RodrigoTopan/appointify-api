package puc.appointify.domain.ports.out.repository;

import puc.appointify.domain.core.entity.OfferedService;

import java.util.List;

public interface OfferedServiceRepository {
    OfferedService save(OfferedService offeredService);

    List<OfferedService> findAll();
}
