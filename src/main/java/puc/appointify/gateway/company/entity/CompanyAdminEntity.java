package puc.appointify.gateway.company.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company_admin")
@Entity
public class CompanyAdminEntity {
    @Id
    private UUID id;

    private String name;
    private String email;
    private String password;

    private String companyName;
    private String companyDescription;
    private String companyGovernmentId;
}
