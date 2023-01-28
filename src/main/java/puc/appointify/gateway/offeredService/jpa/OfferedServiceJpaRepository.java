package puc.appointify.gateway.offeredService.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.appointify.gateway.company.entity.CompanyAdminEntity;
import puc.appointify.gateway.offeredService.entity.OfferedServiceEntity;

import java.util.UUID;

@Repository
public interface OfferedServiceJpaRepository extends JpaRepository<OfferedServiceEntity, UUID> {
}
