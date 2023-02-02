package puc.appointify.domain.core.entity;

import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.core.common.entity.AggregateRoot;
import puc.appointify.domain.core.common.exception.DomainException;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.ScheduleDate;
import puc.appointify.domain.core.entity.valueobject.Username;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class Employee extends AggregateRoot<UUID> {

    private User user;
    private Company company;

    private final List<Schedule> schedules = new ArrayList<>();

    public void initialize() {
        setId(UUID.randomUUID());
    }

    public void loadSchedules(List<Schedule> savedSchedules) {
        savedSchedules.forEach(savedSchedule -> {
            savedSchedule.setAvailable(false);
            savedSchedule.setEmployee(this);
            this.schedules.add(savedSchedule);
        });
    }

    public Schedule addSchedule(Date scheduleDateStart,
                                Date scheduleDateEnd,
                                OfferedService offeredService){
        validate(scheduleDateStart, scheduleDateEnd);
        boolean isAvailable = true;
        var schedule = new Schedule(
                new ScheduleDate(scheduleDateStart, scheduleDateEnd),
                offeredService,
                this,
                isAvailable,
                null);
        schedule.initialize();
        schedules.add(schedule);
        return schedule;
    }

    private void validate(Date scheduleDateStart, Date scheduleDateEnd) {
        schedules.forEach(assignedSchedule -> {
            var start = assignedSchedule.getScheduleDate().getStart();
            var end = assignedSchedule.getScheduleDate().getEnd();
            if (scheduleDateStart.equals(start) && scheduleDateEnd.equals(end))
                throw new DomainException("Employee already has an appointment at this date time");
        });
    }

    public Schedule removeSchedule(Schedule schedule){
        schedules.remove(schedule);
        return schedule;
    }
}
