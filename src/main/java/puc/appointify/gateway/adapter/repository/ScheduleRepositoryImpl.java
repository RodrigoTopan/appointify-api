package puc.appointify.gateway.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.domain.ports.out.repository.ScheduleRepository;
import puc.appointify.gateway.database.entity.ScheduleEntity;
import puc.appointify.gateway.database.jpa.ScheduleJpaRepository;
import puc.appointify.gateway.database.mapper.DataMapper;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ScheduleRepositoryImpl implements ScheduleRepository {
    private final DataMapper<Schedule, ScheduleEntity> scheduleDataAccessMapper;
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
    public List<Schedule> findByCustomerId(UUID id) {
        var entities = scheduleJpaRepository.findByCustomerId(id);
        return entities.stream().map(scheduleDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Schedule> findByEmployeeId(UUID id) {
        var entities = scheduleJpaRepository.findByEmployeeId(id);
        return entities.stream().map(scheduleDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Schedule> findAllByAvailableStatusAndCompanyIdAndDate(UUID companyId, Date startDate, Date endDate) {
        var entities = scheduleJpaRepository.findAllByAvailableStatusAndCompanyIdAndDate(companyId, startDate, endDate);
        return entities.stream().map(scheduleDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        scheduleJpaRepository.deleteById(id);
    }
}
