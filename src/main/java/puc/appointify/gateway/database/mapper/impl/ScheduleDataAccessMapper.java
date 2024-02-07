package puc.appointify.gateway.database.mapper.impl;

import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.domain.core.entity.valueobject.ScheduleDate;
import puc.appointify.gateway.database.entity.ScheduleEntity;

public class ScheduleDataAccessMapper {

    public static ScheduleEntity toEntity(Schedule schedule) {
        if (schedule == null) return null;
        return ScheduleEntity
                .builder()
                .id(schedule.getId())
                .dateStart(schedule.getScheduleDate().getStart())
                .dateEnd(schedule.getScheduleDate().getEnd())
                .employee(EmployeeDataAccessMapper.toEntity(schedule.getEmployee()))
                .offeredService(OfferedServiceDataAccessMapper.toEntity(schedule.getOfferedService()))
                .customer(CustomerDataAccessMapper.toEntity(schedule.getCustomerAssignee()))
                .isAvailable(schedule.isAvailable())
                .build();
    }

    public static Schedule toDomain(ScheduleEntity entity) {
        if (entity == null) return null;

        return new Schedule(
                entity.getId(),
                new ScheduleDate(entity.getDateStart(), entity.getDateEnd()),
                OfferedServiceDataAccessMapper.toDomain(entity.getOfferedService()),
                EmployeeDataAccessMapper.toDomain(entity.getEmployee()),
                entity.isAvailable(),
                CustomerDataAccessMapper.toDomain(entity.getCustomer()));
    }
}
