package puc.appointify.domain.ports.out.repository;

import puc.appointify.domain.core.entity.Schedule;

import java.util.List;
import java.util.UUID;

public interface ScheduleRepository {
    Schedule save(Schedule schedule);

    List<Schedule> findAll();

    Schedule findById(UUID id);

    void deleteById(UUID id);
}
