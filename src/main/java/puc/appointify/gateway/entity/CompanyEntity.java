package puc.appointify.gateway.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
@Table(name = "company_admin")
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

    @OneToMany(mappedBy = "companyAdmin", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<OfferedServiceEntity> offeredServices;
}
