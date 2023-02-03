package puc.appointify.domain.ports.in.employee.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.employee.mapper.EmployeeMapper;
import puc.appointify.domain.ports.in.employee.EmployeeCommandHandler;
import puc.appointify.domain.ports.in.employee.contract.command.CreateEmployeeCommand;
import puc.appointify.domain.ports.in.employee.contract.command.CreateEmployeeCommandResponse;
import puc.appointify.domain.ports.out.repository.CompanyRepository;
import puc.appointify.domain.ports.out.repository.EmployeeRepository;
import puc.appointify.domain.ports.out.repository.UserRepository;

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
