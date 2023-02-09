package puc.appointify.gateway.database.entity;

import jakarta.persistence.Column;
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

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedules")
@Entity
public class ScheduleEntity {
    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private UUID id;

    private Date dateStart;
    private Date dateEnd;
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "offered_service_id")
    private OfferedServiceEntity offeredService;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
