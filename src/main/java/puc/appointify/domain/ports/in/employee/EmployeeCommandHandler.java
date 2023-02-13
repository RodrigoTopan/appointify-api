package puc.appointify.domain.ports.in.employee;

import puc.appointify.domain.ports.in.employee.dto.command.CreateEmployeeCommand;
import puc.appointify.domain.ports.in.employee.dto.command.CreateEmployeeCommandResponse;

public interface EmployeeCommandHandler {
    CreateEmployeeCommandResponse create(CreateEmployeeCommand command);
}
