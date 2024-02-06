package puc.appointify.domain.core.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import puc.appointify.domain.core.common.entity.BaseEntity;
import puc.appointify.domain.core.common.exception.DomainException;
import puc.appointify.domain.core.entity.valueobject.ScheduleDate;

import java.util.UUID;

public class Schedule extends BaseEntity<UUID> {
    private final ScheduleDate scheduleDate;
    private final OfferedService offeredService;
    private final Employee employee;
    private boolean isAvailable;
    private Customer customerAssignee;


    public Schedule(ScheduleDate scheduleDate,
                    OfferedService offeredService,
                    Employee employee) {
        super(UUID.randomUUID());
        this.scheduleDate = scheduleDate;
        this.offeredService = offeredService;
        this.employee = employee;
        this.isAvailable = true;
    }

    public Schedule(UUID id, ScheduleDate scheduleDate, OfferedService offeredService, Employee employee, boolean isAvailable, Customer customerAssignee) {
        super(id);
        this.scheduleDate = scheduleDate;
        this.offeredService = offeredService;
        this.employee = employee;
        this.isAvailable = isAvailable;
        this.customerAssignee = customerAssignee;
    }

    public void createAppointment(Customer customerAssignee) {
        checkIfScheduleAlreadyHasRegisteredCustomer();
        this.isAvailable = false;
        this.customerAssignee = customerAssignee;
    }

    private void checkIfScheduleAlreadyHasRegisteredCustomer() {
        if (this.getCustomerAssignee() != null || !this.isAvailable())
            throw new DomainException("schedule is already assigned to another customer");
    }

    public ScheduleDate getScheduleDate() {
        return scheduleDate;
    }

    public OfferedService getOfferedService() {
        return offeredService;
    }

    public Employee getEmployee() {
        return employee;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Customer getCustomerAssignee() {
        return customerAssignee;
    }
}
