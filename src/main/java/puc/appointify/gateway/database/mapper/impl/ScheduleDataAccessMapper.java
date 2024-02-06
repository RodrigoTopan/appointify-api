package puc.appointify.gateway.database.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.core.entity.OfferedService;
import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.domain.core.entity.valueobject.ScheduleDate;
import puc.appointify.gateway.database.entity.CustomerEntity;
import puc.appointify.gateway.database.entity.OfferedServiceEntity;
import puc.appointify.gateway.database.entity.ScheduleEntity;
import puc.appointify.gateway.database.mapper.DataMapper;
import puc.appointify.gateway.database.mapper.ScheduleMapper;

@Component
@RequiredArgsConstructor
class ScheduleDataAccessMapper implements ScheduleMapper {
    private final EmployeeDataAccessMapper employeeDataAccessMapper;
    private final DataMapper<OfferedService, OfferedServiceEntity> offeredServiceDataAccessMapper;
    private final DataMapper<Customer, CustomerEntity> customerDataAccessMapper;

    public ScheduleEntity toEntity(Schedule schedule) {
        if (schedule == null) return null;
        return ScheduleEntity
                .builder()
                .id(schedule.getId())
                .dateStart(schedule.getScheduleDate().getStart())
                .dateEnd(schedule.getScheduleDate().getEnd())
                .employee(employeeDataAccessMapper.toEntity(schedule.getEmployee()))
                .offeredService(offeredServiceDataAccessMapper.toEntity(schedule.getOfferedService()))
                .customer(customerDataAccessMapper.toEntity(schedule.getCustomerAssignee()))
                .isAvailable(schedule.isAvailable())
                .build();
    }

    public Schedule toDomain(ScheduleEntity entity) {
        if (entity == null) return null;

        return new Schedule(
                entity.getId(),
                new ScheduleDate(entity.getDateStart(), entity.getDateEnd()),
                offeredServiceDataAccessMapper.toDomain(entity.getOfferedService()),
                employeeDataAccessMapper.toDomain(entity.getEmployee()),
                entity.isAvailable(),
                customerDataAccessMapper.toDomain(entity.getCustomer()));
    }
}
