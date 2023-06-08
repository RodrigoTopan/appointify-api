package puc.appointify.domain.core.ports.in.schedules.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.ports.in.schedules.contract.query.FindAppointmentQueryResponse;
import puc.appointify.domain.core.ports.in.schedules.contract.query.FindAvailableSchedulesQuery;
import puc.appointify.domain.core.ports.in.schedules.contract.query.FindAvailableSchedulesQueryResponse;
import puc.appointify.domain.core.ports.in.schedules.contract.query.FindCustomerAppointmentsQuery;
import puc.appointify.domain.core.ports.in.schedules.contract.query.FindScheduleQueryResponse;
import puc.appointify.domain.core.ports.in.schedules.mapper.ScheduleMapper;
import puc.appointify.domain.core.ports.out.repository.ScheduleRepository;
import puc.appointify.domain.core.ports.in.schedules.ScheduleQueryHandler;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ScheduleQueryHandlerImpl implements ScheduleQueryHandler {
    private final ScheduleMapper scheduleMapper;
    private final ScheduleRepository scheduleRepository;

    @Override
    public List<FindScheduleQueryResponse> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(scheduleMapper::scheduleToFindScheduleQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FindAppointmentQueryResponse> find(FindCustomerAppointmentsQuery query) {
        return scheduleRepository.findByCustomerId(query.getCustomerId())
                .stream()
                .map(scheduleMapper::scheduleToFindAppointmentQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FindAvailableSchedulesQueryResponse> find(FindAvailableSchedulesQuery query) {
        return scheduleRepository
                .findAllByAvailableStatusAndCompanyIdAndDate(query.getCompanyId(), query.getRangeStartDate(), query.getRangeEndDate())
                .stream()
                .map(scheduleMapper::scheduleToFindAvailableSchedulesQueryResponse)
                .collect(Collectors.toList());
    }
}
