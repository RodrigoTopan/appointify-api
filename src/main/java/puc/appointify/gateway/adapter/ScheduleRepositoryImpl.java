package puc.appointify.gateway.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Employee;
import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.domain.ports.out.repository.EmployeeRepository;
import puc.appointify.domain.ports.out.repository.ScheduleRepository;
import puc.appointify.gateway.entity.EmployeeEntity;
import puc.appointify.gateway.jpa.EmployeeJpaRepository;
import puc.appointify.gateway.jpa.ScheduleJpaRepository;
import puc.appointify.gateway.mapper.EmployeeDataAccessMapper;
import puc.appointify.gateway.mapper.ScheduleDataAccessMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ScheduleRepositoryImpl implements ScheduleRepository {
    private final ScheduleDataAccessMapper scheduleDataAccessMapper;
    private final ScheduleJpaRepository scheduleJpaRepository;

    @Override
    public Schedule save(Schedule schedule) {
        var entity = scheduleDataAccessMapper.toEntity(schedule);
        var savedEntity = scheduleJpaRepository.save(entity);
        return scheduleDataAccessMapper.toDomain(savedEntity);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleJpaRepository
                .findAll()
                .stream()
                .map(scheduleDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Schedule findById(UUID id) {
        var entity = scheduleJpaRepository.findById(id).orElseThrow();
        return scheduleDataAccessMapper.toDomain(entity);
    }

    @Override
    public void deleteById(UUID id) {
        scheduleJpaRepository.deleteById(id);
    }
}
