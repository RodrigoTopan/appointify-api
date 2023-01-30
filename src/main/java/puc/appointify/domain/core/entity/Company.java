package puc.appointify.domain.core.entity;

import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.core.common.entity.AggregateRoot;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class Company extends AggregateRoot<UUID> {
    private Username name;
    private Email email;
    private Password password;
    private CompanyDetails companyDetails;

    private final List<Employee> employees = new ArrayList<>();

    public void initialize() {
        setId(UUID.randomUUID());
    }

    public Employee createEmployee(String username, String email, String password) {
        var employee = new Employee(
                new Username(username),
                new Email(email),
                new Password(password),
                this);
        employee.initialize();
        employees.add(employee);
        return employee;
    }
}
