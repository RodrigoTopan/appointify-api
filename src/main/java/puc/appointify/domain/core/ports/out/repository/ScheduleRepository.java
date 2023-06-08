package puc.appointify.domain.core.ports.out.repository;

import puc.appointify.domain.core.entity.Schedule;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface ScheduleRepository {
    Schedule save(Schedule schedule);

    List<Schedule> findAll();

    Schedule findById(UUID id);

    List<Schedule> findByCustomerId(UUID id);

    List<Schedule> findByEmployeeId(UUID id);

    List<Schedule> findAllByAvailableStatusAndCompanyIdAndDate(UUID companyId, Date startDate, Date endDate);

    void deleteById(UUID id);
}
