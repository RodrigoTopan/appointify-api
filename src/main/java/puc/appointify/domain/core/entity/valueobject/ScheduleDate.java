package puc.appointify.domain.core.entity.valueobject;

import lombok.Getter;

import java.util.Date;

@Getter
public class ScheduleDate {
    private final Date start;
    private final Date end;

    public ScheduleDate(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
}
