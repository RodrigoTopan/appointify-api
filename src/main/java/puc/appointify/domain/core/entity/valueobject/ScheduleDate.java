package puc.appointify.domain.core.entity.valueobject;

import lombok.Getter;
import static org.springframework.util.ObjectUtils.isEmpty;
import puc.appointify.domain.core.common.exception.DomainException;

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
