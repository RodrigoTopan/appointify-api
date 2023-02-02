package puc.appointify.gateway.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Employee;
import puc.appointify.domain.ports.out.repository.EmployeeRepository;
import puc.appointify.gateway.entity.EmployeeEntity;
import puc.appointify.gateway.jpa.EmployeeJpaRepository;
import puc.appointify.gateway.mapper.DataMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final DataMapper<Employee, EmployeeEntity> employeeDataAccessMapper;
    private final EmployeeJpaRepository employeeJpaRepository;

    @Override
    public Employee save(Employee employee) {
        var employeeEntity = employeeDataAccessMapper.toEntity(employee);
        var savedEntity = employeeJpaRepository.save(employeeEntity);
        return employeeDataAccessMapper.toDomain(savedEntity);
    }

    @Override
    public List<Employee> findAll() {
        List<EmployeeEntity> entities = employeeJpaRepository.findAll();
        return entities
                .stream()
                .map(employeeDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Employee findById(UUID id) {
        var entity = employeeJpaRepository.findById(id).orElseThrow();
        return employeeDataAccessMapper.toDomain(entity);
    }

    @Override
    public void deleteById(UUID id) {
        employeeJpaRepository.deleteById(id);
    }
}
