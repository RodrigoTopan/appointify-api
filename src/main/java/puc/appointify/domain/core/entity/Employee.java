package puc.appointify.domain.core.entity;

import puc.appointify.domain.core.common.entity.BaseEntity;
import puc.appointify.domain.core.common.exception.DomainException;
import puc.appointify.domain.core.entity.valueobject.ScheduleDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Employee extends BaseEntity<UUID> {

    private final User user;
    private final Company company;

    private final List<Schedule> schedules = new ArrayList<>();

    public Employee(User user, Company company) {
        super(UUID.randomUUID());
        this.user = user;
        this.company = company;
    }

    public Employee(UUID id, User user, Company company, List<Schedule> schedules) {
        super(id);
        this.user = user;
        this.company = company;
        this.schedules.addAll(schedules);
    }

    public Schedule addSchedule(Date scheduleDateStart,
                                Date scheduleDateEnd,
                                OfferedService offeredService){
        var schedule = new Schedule(
                new ScheduleDate(scheduleDateStart, scheduleDateEnd),
                offeredService,
                this);

        validateIfThereIsConflicts(schedule);
        schedules.add(schedule);
        return schedule;
    }

    private void validateIfThereIsConflicts(Schedule schedule) {
        schedules.forEach(assignedSchedule -> {
            var start = assignedSchedule.getScheduleDate().getStart();
            var end = assignedSchedule.getScheduleDate().getEnd();
            if (schedule.getScheduleDate().getStart().equals(start) && schedule.getScheduleDate().getEnd().equals(end))
                throw new DomainException("Employee already has an appointment at this date time");
        });
    }

    public Schedule removeSchedule(Schedule schedule){
        schedules.remove(schedule);
        return schedule;
    }

    public User getUser() {
        return user;
    }

    public Company getCompany() {
        return company;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}
