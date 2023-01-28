package puc.appointify.gateway.offeredservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.appointify.gateway.offeredservice.entity.OfferedServiceEntity;

import java.util.UUID;

@Repository
public interface OfferedServiceJpaRepository extends JpaRepository<OfferedServiceEntity, UUID> {
}
