package puc.appointify.domain.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.Schedule;
import puc.appointify.domain.ports.in.schedules.contract.CompanyDTO;
import puc.appointify.domain.ports.in.schedules.contract.CustomerDTO;
import puc.appointify.domain.ports.in.schedules.contract.EmployeeDTO;
import puc.appointify.domain.ports.in.schedules.contract.ScheduleDTO;
import puc.appointify.domain.ports.in.schedules.contract.ServiceDTO;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateAppointmentCommandResponse;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateScheduleCommandResponse;
import puc.appointify.domain.ports.in.schedules.contract.query.FindAppointmentQueryResponse;
import puc.appointify.domain.ports.in.schedules.contract.query.FindScheduleQueryResponse;

@Component
public class ScheduleMapper {

    public CreateScheduleCommandResponse scheduleToCreateScheduleCommandResponse(Schedule schedule) {
        return CreateScheduleCommandResponse
                .builder()
                .id(schedule.getId())
                .scheduleStart(schedule.getScheduleDate().getStart())
                .scheduleEnd(schedule.getScheduleDate().getEnd())
                .employeeId(schedule.getEmployee().getId())
                .offeredServiceId(schedule.getOfferedService().getId())
                .isAvailable(schedule.isAvailable())
                .customerAssigneeId(schedule.getCustomerAssignee() == null ? null : schedule.getCustomerAssignee().getId())
                .build();
    }

    public CreateAppointmentCommandResponse scheduleToCreateAppointmentCommandResponse(Schedule schedule) {
        var company = schedule.getEmployee().getCompany();
        var customer = schedule.getCustomerAssignee();
        var employee = schedule.getEmployee();
        var service = schedule.getOfferedService();

        return CreateAppointmentCommandResponse
                .builder()
                .schedule(ScheduleDTO
                        .builder()
                        .id(schedule.getId())
                        .startDate(schedule.getScheduleDate().getStart())
                        .endDate(schedule.getScheduleDate().getEnd())
                        .build())
                .company(CompanyDTO
                        .builder()
                        .id(company.getId())
                        .name(company.getName().getValue())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .build())
                .customer(CustomerDTO
                        .builder()
                        .id(customer.getId())
                        .email(customer.getName().getValue())
                        .name(customer.getEmail().getValue())
                        .build())
                .employee(EmployeeDTO
                        .builder()
                        .id(employee.getId())
                        .name(employee.getName().getValue())
                        .build())
                .service(ServiceDTO
                        .builder()
                        .id(service.getId())
                        .name(service.getName())
                        .description(service.getDescription())
                        .price(service.getPrice().getAmount())
                        .build())
                .build();
    }


    public FindScheduleQueryResponse scheduleToFindScheduleQueryResponse(Schedule schedule) {
        return FindScheduleQueryResponse
                .builder()
                .id(schedule.getId())
                .scheduleStart(schedule.getScheduleDate().getStart())
                .scheduleEnd(schedule.getScheduleDate().getEnd())
                .employeeId(schedule.getEmployee().getId())
                .offeredServiceId(schedule.getOfferedService().getId())
                .isAvailable(schedule.isAvailable())
                .customerAssigneeId(schedule.getCustomerAssignee() == null ? null : schedule.getCustomerAssignee().getId())
                .build();
    }

    public FindAppointmentQueryResponse scheduleToFindAppointmentQueryResponse(Schedule schedule) {
        var company = schedule.getEmployee().getCompany();
        var customer = schedule.getCustomerAssignee();
        var employee = schedule.getEmployee();
        var service = schedule.getOfferedService();

        return FindAppointmentQueryResponse
                .builder()
                .schedule(ScheduleDTO
                        .builder()
                        .id(schedule.getId())
                        .startDate(schedule.getScheduleDate().getStart())
                        .endDate(schedule.getScheduleDate().getEnd())
                        .build())
                .company(CompanyDTO
                        .builder()
                        .id(company.getId())
                        .name(company.getName().getValue())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .build())
                .customer(CustomerDTO
                        .builder()
                        .id(customer.getId())
                        .email(customer.getName().getValue())
                        .name(customer.getEmail().getValue())
                        .build())
                .employee(EmployeeDTO
                        .builder()
                        .id(employee.getId())
                        .name(employee.getName().getValue())
                        .build())
                .service(ServiceDTO
                        .builder()
                        .id(service.getId())
                        .name(service.getName())
                        .description(service.getDescription())
                        .price(service.getPrice().getAmount())
                        .build())
                .build();
    }

}
