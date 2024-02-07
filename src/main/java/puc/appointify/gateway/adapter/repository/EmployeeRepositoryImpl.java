package puc.appointify.gateway.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Employee;
import puc.appointify.domain.core.ports.out.repository.EmployeeRepository;
import puc.appointify.gateway.database.entity.EmployeeEntity;
import puc.appointify.gateway.database.jpa.EmployeeJpaRepository;
import puc.appointify.gateway.database.mapper.impl.EmployeeDataAccessMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EmployeeJpaRepository employeeJpaRepository;

    @Override
    public Employee save(Employee employee) {
        var employeeEntity = EmployeeDataAccessMapper.toEntity(employee);
        var savedEntity = employeeJpaRepository.save(employeeEntity);
        return EmployeeDataAccessMapper.toDomain(savedEntity);
    }

    @Override
    public List<Employee> findAll() {
        List<EmployeeEntity> entities = employeeJpaRepository.findAll();
        return entities
                .stream()
                .map(EmployeeDataAccessMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Employee findById(UUID id) {
        var entity = employeeJpaRepository.findById(id).orElseThrow();
        return EmployeeDataAccessMapper.toDomain(entity);
    }

    @Override
    public void deleteById(UUID id) {
        employeeJpaRepository.deleteById(id);
    }
}
