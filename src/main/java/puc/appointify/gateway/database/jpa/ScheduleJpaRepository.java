package puc.appointify.gateway.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import puc.appointify.gateway.database.entity.ScheduleEntity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface ScheduleJpaRepository extends JpaRepository<ScheduleEntity, UUID> {

    List<ScheduleEntity> findByCustomerId(UUID customerId);
    List<ScheduleEntity> findByEmployeeId(UUID employeeId);

    @Query("select s from ScheduleEntity s where s.isAvailable = true and s.offeredService.company.id = ?1")
    List<ScheduleEntity> findAllByAvailableStatusAndCompanyId(UUID id);

    @Query("select s from ScheduleEntity s where s.isAvailable = true and s.offeredService.company.id = ?1 and s.dateStart < ?2 and s.dateEnd > ?3")
    List<ScheduleEntity> findAllByAvailableStatusAndCompanyIdAndDate(UUID id, Date dateStart, Date dateEnd);
}
