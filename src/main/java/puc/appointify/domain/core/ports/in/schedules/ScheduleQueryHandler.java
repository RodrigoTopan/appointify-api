package puc.appointify.domain.core.ports.in.schedules;

import puc.appointify.domain.core.ports.in.schedules.contract.query.FindAppointmentQueryResponse;
import puc.appointify.domain.core.ports.in.schedules.contract.query.FindAvailableSchedulesQuery;
import puc.appointify.domain.core.ports.in.schedules.contract.query.FindAvailableSchedulesQueryResponse;
import puc.appointify.domain.core.ports.in.schedules.contract.query.FindCustomerAppointmentsQuery;
import puc.appointify.domain.core.ports.in.schedules.contract.query.FindScheduleQueryResponse;

import java.util.List;

public interface ScheduleQueryHandler {
    List<FindScheduleQueryResponse> findAll();

    List<FindAppointmentQueryResponse> find(FindCustomerAppointmentsQuery query);

    List<FindAvailableSchedulesQueryResponse> find(FindAvailableSchedulesQuery query);
}
