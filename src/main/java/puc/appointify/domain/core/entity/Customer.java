package puc.appointify.domain.core.entity;

import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.core.common.entity.AggregateRoot;
import puc.appointify.domain.core.common.exception.DomainException;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class Customer extends AggregateRoot<UUID> {
    private Username name;
    private Email email;
    private Password password;

    private final List<Schedule> schedules = new ArrayList<>();

    public void initialize() {
        setId(UUID.randomUUID());
    }

    public void assignAppointments(List<Schedule> schedules) {
        schedules.forEach(this::assignAppointment);
    }

    public Schedule assignAppointment(Schedule schedule) {
        validateAssignment(schedule);
        schedule.setAvailable(false);
        schedule.setCustomerAssignee(this);
        schedules.add(schedule);
        return schedule;
    }

    private void validateAssignment(Schedule schedule) {
        checkIfCustomerAlreadyHasAssignedForThisSchedule(schedule);
        checkIfCustomerAlreadyHasDateConflicts(schedule);
        checkIfScheduleAlreadyHasRegisteredCustomer(schedule);
    }

    private void checkIfScheduleAlreadyHasRegisteredCustomer(Schedule schedule) {
        if(schedule.getCustomerAssignee() != null || !schedule.isAvailable())
            throw new DomainException("schedule is already assigned to another customer");
    }

    private void checkIfCustomerAlreadyHasAssignedForThisSchedule(Schedule schedule) {
        if(schedules.stream().anyMatch(assignedSchedule -> assignedSchedule.getId().equals(schedule.getId())))
            throw new DomainException("schedule is already assigned to you");
    }

    private void checkIfCustomerAlreadyHasDateConflicts(Schedule schedule) {
        schedules.forEach(assignedSchedule -> {
            var start = assignedSchedule.getScheduleDate().getStart();
            var end = assignedSchedule.getScheduleDate().getEnd();
            var compareStart = schedule.getScheduleDate().getStart();
            var comparedEnd = schedule.getScheduleDate().getEnd();
            if (compareStart.after(start) && comparedEnd.before(end))
                throw new DomainException("schedule conflicts with an appointment already assigned to you");
        });
    }
}
