package puc.appointify.domain.core.entity;

import puc.appointify.domain.core.common.entity.BaseEntity;
import puc.appointify.domain.core.common.exception.DomainException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer extends BaseEntity<UUID> {

    private final User user;

    private final List<Schedule> schedules = new ArrayList<>();

    private final List<Evaluation> evaluations = new ArrayList<>();

    public Customer(User user) {
        super(UUID.randomUUID());
        this.user = user;
    }

    public Customer(User user, List<Schedule> schedules, List<Evaluation> evaluations) {
        super(UUID.randomUUID());
        this.user = user;
        this.schedules.addAll(schedules);
        this.evaluations.addAll(evaluations);
    }

    public Customer(UUID id, User user, List<Schedule> schedules, List<Evaluation> evaluations) {
        super(id);
        this.user = user;
        this.schedules.addAll(schedules);
        this.evaluations.addAll(evaluations);
    }

    public Schedule assignAppointment(Schedule schedule) {
        validateAssignment(schedule);
        schedule.createAppointment(this);
        schedules.add(schedule);
        return schedule;
    }

    private void validateAssignment(Schedule schedule) {
        checkIfCustomerAlreadyHasAssignedForThisSchedule(schedule);
        checkIfCustomerAlreadyHasDateConflicts(schedule);
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
        this.evaluations.add(evaluation);
        return evaluation;
    }

    public User getUser() {
        return user;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }
}
