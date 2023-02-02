package puc.appointify.gateway.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.appointify.gateway.entity.EmployeeEntity;

import java.util.UUID;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, UUID> {
}
