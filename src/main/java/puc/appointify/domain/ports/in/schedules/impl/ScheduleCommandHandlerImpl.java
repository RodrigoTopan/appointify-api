package puc.appointify.domain.ports.in.schedules.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.mapper.ScheduleMapper;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateAppointmentCommand;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateAppointmentCommandResponse;
import puc.appointify.domain.ports.in.schedules.SchedulesCommandHandler;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateScheduleCommand;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateScheduleCommandResponse;
import puc.appointify.domain.ports.out.repository.CustomerRepository;
import puc.appointify.domain.ports.out.repository.EmployeeRepository;
import puc.appointify.domain.ports.out.repository.OfferedServiceRepository;
import puc.appointify.domain.ports.out.repository.ScheduleRepository;

@Component
@RequiredArgsConstructor
public class ScheduleCommandHandlerImpl implements SchedulesCommandHandler {
    private final ScheduleMapper scheduleMapper;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final OfferedServiceRepository offeredServiceRepository;
    private final ScheduleRepository scheduleRepository;

    @Override
    public CreateScheduleCommandResponse create(CreateScheduleCommand command) {
        var employee = employeeRepository.findById(command.getEmployeeId());
        var offeredService = offeredServiceRepository.findById(command.getOfferedServiceId());

        var schedule = employee.addSchedule(
                command.getScheduleStart(),
                command.getScheduleEnd(),
                offeredService);

        var savedSchedule = scheduleRepository.save(schedule);
        return scheduleMapper.scheduleToCreateScheduleCommandResponse(savedSchedule);
    }

    @Override
    public CreateAppointmentCommandResponse create(CreateAppointmentCommand command) {
        var customer = customerRepository.findById(command.getCustomerId());
        var schedule = scheduleRepository.findById(command.getScheduleId());
        var assignedSchedule = customer.assignAppointment(schedule);
        var savedAssignedSchedule = scheduleRepository.save(assignedSchedule);
        return scheduleMapper.scheduleToCreateAppointmentCommandResponse(savedAssignedSchedule);
    }

}