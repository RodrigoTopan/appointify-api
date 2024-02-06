package puc.appointify.domain.core.entity;

import puc.appointify.domain.core.common.entity.BaseEntity;
import puc.appointify.domain.core.entity.valueobject.CompanyDetails;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.UserRole;
import puc.appointify.domain.core.entity.valueobject.Username;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User extends BaseEntity<UUID> {
    private final String firstName;
    private final String lastName;
    private final Username username;
    private final Email email;
    private final Password password;
    private final UserRole role;

    //TODO: adicionar foto

    public User(String firstName, String lastName, Username username, Email email, Password password, UserRole role) {
        super(UUID.randomUUID());
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(UUID uuid, String firstName, String lastName, Username username, Email email, Password password, UserRole role) {
        super(uuid);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Customer createCustomer() {
        return new Customer(this);
    }

    public Company createCompany(CompanyDetails companyDetails, List<Category> companyCategories) {
        return new Company(this, companyDetails, new ArrayList<>(), companyCategories);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Username getUsername() {
        return username;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }
}
