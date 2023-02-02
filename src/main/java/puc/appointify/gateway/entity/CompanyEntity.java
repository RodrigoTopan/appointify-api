package puc.appointify.gateway.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "companies")
@Entity
public class CompanyEntity {
    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private UUID id;

    private String name;
    private String email;
    private String password;

    private String companyName;
    private String companyDescription;
    private String companyGovernmentId;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<OfferedServiceEntity> offeredServices;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<EmployeeEntity> employees;

    @ManyToMany
    private List<CategoryEntity> categories;
}
