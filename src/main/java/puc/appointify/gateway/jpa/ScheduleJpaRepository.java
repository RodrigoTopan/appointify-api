package puc.appointify.gateway.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.gateway.entity.ScheduleEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface ScheduleJpaRepository extends JpaRepository<ScheduleEntity, UUID> {

    List<ScheduleEntity> findByCustomerId(UUID customerId);
    List<ScheduleEntity> findByEmployeeId(UUID employeeId);
}
