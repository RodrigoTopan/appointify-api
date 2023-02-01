package puc.appointify.gateway.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.core.entity.Employee;
import puc.appointify.domain.core.entity.OfferedService;
import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.domain.core.entity.valueobject.ScheduleDate;
import puc.appointify.gateway.entity.CustomerEntity;
import puc.appointify.gateway.entity.EmployeeEntity;
import puc.appointify.gateway.entity.OfferedServiceEntity;
import puc.appointify.gateway.entity.ScheduleEntity;
import puc.appointify.gateway.mapper.DataMapper;

@Component
@RequiredArgsConstructor
class ScheduleDataAccessMapper implements DataMapper<Schedule, ScheduleEntity> {
    private final DataMapper<Employee, EmployeeEntity> employeeDataAccessMapper;
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
        var domain = Schedule
                .builder()
                .scheduleDate(new ScheduleDate(entity.getDateStart(), entity.getDateEnd()))
                .offeredService(offeredServiceDataAccessMapper.toDomain(entity.getOfferedService()))
                .employee(employeeDataAccessMapper.toDomain(entity.getEmployee()))
                .isAvailable(entity.isAvailable())
                .customerAssignee(customerDataAccessMapper.toDomain(entity.getCustomer()))
                .build();

        domain.setId(entity.getId());
        return domain;
    }
}
