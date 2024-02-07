package puc.appointify.gateway.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.domain.core.ports.out.repository.ScheduleRepository;
import puc.appointify.gateway.database.jpa.ScheduleJpaRepository;
import puc.appointify.gateway.database.mapper.impl.ScheduleDataAccessMapper;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ScheduleRepositoryImpl implements ScheduleRepository {
    private final ScheduleJpaRepository scheduleJpaRepository;

    @Override
    public Schedule save(Schedule schedule) {
        var entity = ScheduleDataAccessMapper.toEntity(schedule);
        var savedEntity = scheduleJpaRepository.save(entity);
        return ScheduleDataAccessMapper.toDomain(savedEntity);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleJpaRepository
                .findAll()
                .stream()
                .map(ScheduleDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Schedule findById(UUID id) {
        var entity = scheduleJpaRepository.findById(id).orElseThrow();
        return ScheduleDataAccessMapper.toDomain(entity);
    }

    @Override
    public List<Schedule> findByCustomerId(UUID id) {
        var entities = scheduleJpaRepository.findByCustomerId(id);
        return entities.stream().map(ScheduleDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Schedule> findByEmployeeId(UUID id) {
        var entities = scheduleJpaRepository.findByEmployeeId(id);
        return entities.stream().map(ScheduleDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Schedule> findAllByAvailableStatusAndCompanyIdAndDate(UUID companyId, Date startDate, Date endDate) {
        var entities = scheduleJpaRepository.findAllByAvailableStatusAndCompanyId(companyId); //findAllByAvailableStatusAndCompanyId
        return entities.stream().map(ScheduleDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        scheduleJpaRepository.deleteById(id);
    }
}
