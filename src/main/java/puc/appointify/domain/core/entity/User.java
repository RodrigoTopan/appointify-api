package puc.appointify.domain.core.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import puc.appointify.domain.core.common.entity.AggregateRoot;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.UserRole;
import puc.appointify.domain.core.entity.valueobject.Username;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class User extends AggregateRoot<UUID> {
    private String firstName;
    private String lastName;
    private Username username;
    private Email email;
    private Password password;
    private UserRole role;

    //TODO: adicionar foto

    public void initialize() {
        setId(UUID.randomUUID());
    }

    public Customer createCustomer() {
        var customer = new Customer(this);
        customer.initialize();
        return customer;
    }

    public Company createCompany(CompanyDetails companyDetails, List<Category> companyCategories) {
        var company = new Company(this, companyDetails);
        company.initialize();
        company.loadCategories(companyCategories);
        return company;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
