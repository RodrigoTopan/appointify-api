package puc.appointify.domain.core.entity;

import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.core.common.entity.AggregateRoot;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class Company extends AggregateRoot<UUID> {
    private User user;
    private CompanyDetails companyDetails;
    private final List<Employee> employees = new ArrayList<>();

    private final List<Category> categories = new ArrayList<>();

    public void initialize() {
        setId(UUID.randomUUID());
    }

    public Employee createEmployee(User user) {
        var employee = new Employee(user, this);
        employee.initialize();
        employees.add(employee);
        return employee;
    }

    public void loadCategories(List<Category> savedCategories) {
        this.categories.addAll(savedCategories);
    }

    public void addCategory(Category category) {
        categories.add(category);
    }
}
