package puc.appointify.domain.core.ports.out.repository;

import puc.appointify.domain.core.entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository {
    Employee save(Employee employee);

    List<Employee> findAll();

    Employee findById(UUID id);

    void deleteById(UUID id);
}
