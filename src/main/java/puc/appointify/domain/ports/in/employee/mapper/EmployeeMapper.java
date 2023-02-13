package puc.appointify.domain.ports.in.employee.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Employee;
import puc.appointify.domain.ports.in.employee.dto.command.CreateEmployeeCommandResponse;
import puc.appointify.domain.ports.in.employee.dto.query.FindEmployeeQueryResponse;

@Component
public class EmployeeMapper {

    public CreateEmployeeCommandResponse employeeToCreateEmployeeCommandResponse(Employee employee) {
        return CreateEmployeeCommandResponse
                .builder()
                .id(employee.getId())
                .userId(employee.getUser().getId())
                .companyId(employee.getCompany().getId())
                .build();
    }

    public FindEmployeeQueryResponse employeeToFindEmployeeQueryResponse(Employee employee) {
        return FindEmployeeQueryResponse
                .builder()
                .id(employee.getId())
                .userId(employee.getUser().getId())
                .schedules(employee.getSchedules())
                .companyId(employee.getCompany().getId())
                .build();
    }
}
