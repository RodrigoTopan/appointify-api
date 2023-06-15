package puc.appointify.domain.core.ports.in.employee;

import puc.appointify.domain.core.ports.in.employee.contract.command.CreateEmployeeCommand;
import puc.appointify.domain.core.ports.in.employee.contract.command.CreateEmployeeCommandResponse;

public interface EmployeeCommandHandler {
    CreateEmployeeCommandResponse create(CreateEmployeeCommand command);
}
