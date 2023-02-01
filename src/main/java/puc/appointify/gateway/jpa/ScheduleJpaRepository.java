package puc.appointify.gateway.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.gateway.entity.ScheduleEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ScheduleJpaRepository extends JpaRepository<ScheduleEntity, UUID> {

    List<ScheduleEntity> findByCustomerId(UUID customerId);
    List<ScheduleEntity> findByEmployeeId(UUID employeeId);

    @Query("select s from ScheduleEntity s where s.isAvailable = true and s.offeredService.company.id = ?1")
    List<ScheduleEntity> findAllByAvailableStatusAndCompanyId(UUID id);

    @Query("""
            select s from ScheduleEntity s
            where s.isAvailable = true and s.offeredService.company.id = ?1 and s.dateStart < ?2 and s.dateEnd > ?3""")
    List<ScheduleEntity> findAllByAvailableStatusAndCompanyIdAndDate(UUID id, Date dateStart, Date dateEnd);
}
