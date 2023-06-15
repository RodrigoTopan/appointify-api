package puc.appointify.gateway.database.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "categories")
@Entity
public class CategoryEntity {
    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private UUID id;

    private String name;
    private String image;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<CompanyEntity> companies;
}
