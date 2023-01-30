package puc.appointify.gateway.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.appointify.gateway.entity.ScheduleEntity;

import java.util.UUID;

@Repository
public interface ScheduleJpaRepository extends JpaRepository<ScheduleEntity, UUID> {
}
