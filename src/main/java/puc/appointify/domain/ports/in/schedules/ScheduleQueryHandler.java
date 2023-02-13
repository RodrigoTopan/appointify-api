package puc.appointify.domain.ports.in.schedules;

import puc.appointify.domain.ports.in.schedules.dto.query.FindAppointmentQueryResponse;
import puc.appointify.domain.ports.in.schedules.dto.query.FindAvailableSchedulesQueryResponse;
import puc.appointify.domain.ports.in.schedules.dto.query.FindAvailableSchedulesQuery;
import puc.appointify.domain.ports.in.schedules.dto.query.FindCustomerAppointmentsQuery;
import puc.appointify.domain.ports.in.schedules.dto.query.FindScheduleQueryResponse;

import java.util.List;

public interface ScheduleQueryHandler {
    List<FindScheduleQueryResponse> findAll();

    List<FindAppointmentQueryResponse> find(FindCustomerAppointmentsQuery query);

    List<FindAvailableSchedulesQueryResponse> find(FindAvailableSchedulesQuery query);
}
