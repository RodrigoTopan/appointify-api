package puc.appointify.domain.core.entity.valueobject;

import java.util.Date;

public class ScheduleDate {
    private final Date start;
    private final Date end;

    public ScheduleDate(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
