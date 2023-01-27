package puc.appointify.gateway.company.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.appointify.gateway.company.entity.CompanyAdminEntity;

import java.util.UUID;

@Repository
public interface CompanyAdminJpaRepository extends JpaRepository<CompanyAdminEntity, UUID> {
}
