package puc.appointify.domain.core.entity;

import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.core.common.entity.AggregateRoot;
import puc.appointify.domain.core.common.exception.DomainException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class Customer extends AggregateRoot<UUID> {

    private User user;

    private final List<Schedule> schedules = new ArrayList<>();

    private final List<Evaluation> evaluations = new ArrayList<>();

    public void initialize() {
        setId(UUID.randomUUID());
    }

    public void loadAppointments(List<Schedule> savedSchedules) {
        savedSchedules.forEach(savedSchedule -> {
            savedSchedule.setAvailable(false);
            savedSchedule.setCustomerAssignee(this);
            this.schedules.add(savedSchedule);
        });
    }

    public void loadEvaluations(List<Evaluation> savedEvaluations) {
        this.evaluations.addAll(savedEvaluations);
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
        if (schedule.getCustomerAssignee() != null || !schedule.isAvailable())
            throw new DomainException("schedule is already assigned to another customer");
    }

    private void checkIfCustomerAlreadyHasAssignedForThisSchedule(Schedule schedule) {
        var hasEqualCustomerAssignee = this.schedules.stream().anyMatch(assignedSchedule -> {
            if (assignedSchedule.getCustomerAssignee() == null) return false;
            var customerId = assignedSchedule.getCustomerAssignee().getId();
            var scheduleId = assignedSchedule.getId();
            return customerId.compareTo(this.getId()) == 0
                    && scheduleId.compareTo(schedule.getId()) == 0;
        });

        if (hasEqualCustomerAssignee)
            throw new DomainException("schedule is already assigned to you");
    }

    private void checkIfCustomerAlreadyHasDateConflicts(Schedule schedule) {
        schedules.forEach(assignedSchedule -> {
            var start = assignedSchedule.getScheduleDate().getStart();
            var end = assignedSchedule.getScheduleDate().getEnd();
            var compareStart = schedule.getScheduleDate().getStart();
            var comparedEnd = schedule.getScheduleDate().getEnd();
            if (start.before(comparedEnd) && end.after(compareStart))
                throw new DomainException("schedule conflicts with an appointment already assigned to you");
        });
    }

    public Evaluation evaluateEmployee(Integer rate, String comment, Employee employee) {
        var evaluation = new Evaluation(rate, comment, employee, this);
        evaluation.initialize();
        this.evaluations.add(evaluation);
        return evaluation;
    }
}
