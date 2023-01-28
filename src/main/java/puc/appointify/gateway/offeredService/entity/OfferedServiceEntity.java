package puc.appointify.gateway.offeredService.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import puc.appointify.gateway.company.entity.CompanyAdminEntity;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "offered_services")
@Entity
public class OfferedServiceEntity {
    @Id
    private UUID id;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.REFRESH)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "company_admin_id")
    @EqualsAndHashCode.Include
    private CompanyAdminEntity companyAdmin;

    private String name;
    private String description;
    private BigDecimal price;
}
