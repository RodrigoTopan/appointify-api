package puc.appointify.domain.core.entity;

import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.core.common.entity.AggregateRoot;
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
    private Username name;
    private Email email;
    private Password password;
    private Company company;

    private final List<Schedule> schedules = new ArrayList<>();

    public void initialize() {
        setId(UUID.randomUUID());
    }

    public Schedule addSchedule(Date scheduleDateStart,
                                Date scheduleDateEnd,
                                OfferedService offeredService){
        boolean isAvailable = true;
        var schedule = new Schedule(
                new ScheduleDate(scheduleDateStart, scheduleDateEnd),
                offeredService,
                this,
                isAvailable);
        schedule.initialize();
        schedules.add(schedule);
        return schedule;
    }

    public Schedule removeSchedule(Schedule schedule){
        schedules.remove(schedule);
        return schedule;
    }
}
