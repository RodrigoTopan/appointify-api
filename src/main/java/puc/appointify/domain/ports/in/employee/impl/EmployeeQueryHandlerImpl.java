package puc.appointify.domain.ports.in.employee.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.employee.mapper.EmployeeMapper;
import puc.appointify.domain.ports.in.employee.EmployeeQueryHandler;
import puc.appointify.domain.ports.in.employee.contract.query.FindEmployeeQueryResponse;
import puc.appointify.domain.ports.out.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployeeQueryHandlerImpl implements EmployeeQueryHandler {
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public List<FindEmployeeQueryResponse> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::employeeToFindEmployeeQueryResponse)
                .collect(Collectors.toList());
    }
}
