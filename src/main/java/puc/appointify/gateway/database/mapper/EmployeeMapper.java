package puc.appointify.gateway.database.mapper;

import puc.appointify.domain.core.entity.Employee;
import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.gateway.database.entity.EmployeeEntity;
import puc.appointify.gateway.database.entity.ScheduleEntity;

public interface EmployeeMapper {
    EmployeeEntity toEntity(Employee employee);
    Employee toDomain(EmployeeEntity entity);
}

