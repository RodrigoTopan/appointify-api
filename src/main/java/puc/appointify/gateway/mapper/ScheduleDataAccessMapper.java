package puc.appointify.gateway.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.domain.core.entity.valueobject.ScheduleDate;
import puc.appointify.gateway.entity.ScheduleEntity;

@Component
@RequiredArgsConstructor
public class ScheduleDataAccessMapper {
    private final EmployeeDataAccessMapper employeeDataAccessMapper;
    private final OfferedServiceDataAccessMapper offeredServiceDataAccessMapper;

    public ScheduleEntity toEntity(Schedule schedule) {
        return ScheduleEntity
                .builder()
                .id(schedule.getId())
                .dateStart(schedule.getScheduleDate().getStart())
                .dateEnd(schedule.getScheduleDate().getEnd())
                .employee(employeeDataAccessMapper.toEntity(schedule.getEmployee()))
                .offeredService(offeredServiceDataAccessMapper.toEntity(schedule.getOfferedService()))
                .isAvailable(schedule.isAvailable())
                .build();
    }

    public Schedule toDomain(ScheduleEntity entity) {

        var domain = Schedule
                .builder()
                .scheduleDate(new ScheduleDate(entity.getDateStart(), entity.getDateEnd()))
                .offeredService(offeredServiceDataAccessMapper.toDomain(entity.getOfferedService()))
                .employee(employeeDataAccessMapper.toDomain(entity.getEmployee()))
                .isAvailable(entity.isAvailable())
                .build();

        domain.setId(entity.getId());
        return domain;
    }
}
