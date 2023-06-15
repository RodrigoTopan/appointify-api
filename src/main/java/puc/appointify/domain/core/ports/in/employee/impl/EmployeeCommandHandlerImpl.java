package puc.appointify.domain.core.ports.in.employee.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.ports.out.repository.EmployeeRepository;
import puc.appointify.domain.core.ports.out.repository.UserRepository;
import puc.appointify.domain.core.ports.in.employee.mapper.EmployeeMapper;
import puc.appointify.domain.core.ports.in.employee.EmployeeCommandHandler;
import puc.appointify.domain.core.ports.in.employee.contract.command.CreateEmployeeCommand;
import puc.appointify.domain.core.ports.in.employee.contract.command.CreateEmployeeCommandResponse;
import puc.appointify.domain.core.ports.out.repository.CompanyRepository;

@Component
@RequiredArgsConstructor
public class EmployeeCommandHandlerImpl implements EmployeeCommandHandler {
    private final EmployeeMapper employeeMapper;
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    private final UserRepository userRepository;

    @Override
    public CreateEmployeeCommandResponse create(CreateEmployeeCommand command) {
        var company = companyRepository.findById(command.getCompanyId());
        var user = userRepository.findById(command.getUserId());
        var employee = company.createEmployee(user);
        var savedEmployeeEntity = employeeRepository.save(employee);
        return employeeMapper.employeeToCreateEmployeeCommandResponse(savedEmployeeEntity);
    }
}
