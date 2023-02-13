package puc.appointify.domain.ports.in.schedules.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.schedules.dto.Company;
import puc.appointify.domain.ports.in.schedules.dto.Customer;
import puc.appointify.domain.ports.in.schedules.dto.Employee;
import puc.appointify.domain.ports.in.schedules.dto.Schedule;
import puc.appointify.domain.ports.in.schedules.dto.Service;
import puc.appointify.domain.ports.in.schedules.dto.command.CreateAppointmentCommandResponse;
import puc.appointify.domain.ports.in.schedules.dto.command.CreateScheduleCommandResponse;
import puc.appointify.domain.ports.in.schedules.dto.query.FindAppointmentQueryResponse;
import puc.appointify.domain.ports.in.schedules.dto.query.FindAvailableSchedulesQueryResponse;
import puc.appointify.domain.ports.in.schedules.dto.query.FindScheduleQueryResponse;

@Component
public class ScheduleMapper {

    public CreateScheduleCommandResponse scheduleToCreateScheduleCommandResponse(puc.appointify.domain.core.entity.Schedule schedule) {
        return CreateScheduleCommandResponse
                .builder()
                .id(schedule.getId())
                .scheduleStart(schedule.getScheduleDate().getStart())
                .scheduleEnd(schedule.getScheduleDate().getEnd())
                .employeeId(schedule.getEmployee().getId())
                .offeredServiceId(schedule.getOfferedService().getId())
                .isAvailable(schedule.isAvailable())
                .customerAssigneeId(
                        schedule.getCustomerAssignee() == null ?
                                null : schedule.getCustomerAssignee().getId())
                .build();
    }

    public CreateAppointmentCommandResponse scheduleToCreateAppointmentCommandResponse(puc.appointify.domain.core.entity.Schedule schedule) {
        var company = schedule.getEmployee().getCompany();
        var customer = schedule.getCustomerAssignee();
        var employee = schedule.getEmployee();
        var service = schedule.getOfferedService();

        return CreateAppointmentCommandResponse
                .builder()
                .schedule(Schedule
                        .builder()
                        .id(schedule.getId())
                        .startDate(schedule.getScheduleDate().getStart())
                        .endDate(schedule.getScheduleDate().getEnd())
                        .build())
                .company(Company
                        .builder()
                        .id(company.getId())
                        .name(company.getCompanyDetails().getName())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .build())
                .customer(Customer
                        .builder()
                        .id(customer.getId())
                        .email(customer.getUser().getEmail().getValue())
                        .name(customer.getUser().getFullName())
                        .build())
                .employee(Employee
                        .builder()
                        .id(employee.getId())
                        .name(employee.getUser().getFullName())
                        .build())
                .service(Service
                        .builder()
                        .id(service.getId())
                        .name(service.getName())
                        .description(service.getDescription())
                        .price(service.getPrice().getAmount())
                        .build())
                .build();
    }


    public FindScheduleQueryResponse scheduleToFindScheduleQueryResponse(puc.appointify.domain.core.entity.Schedule schedule) {
        return FindScheduleQueryResponse
                .builder()
                .id(schedule.getId())
                .scheduleStart(schedule.getScheduleDate().getStart())
                .scheduleEnd(schedule.getScheduleDate().getEnd())
                .employeeId(schedule.getEmployee().getId())
                .offeredServiceId(schedule.getOfferedService().getId())
                .isAvailable(schedule.isAvailable())
                .customerAssigneeId(
                        schedule.getCustomerAssignee() == null
                                ? null : schedule.getCustomerAssignee().getId())
                .build();
    }

    public FindAppointmentQueryResponse scheduleToFindAppointmentQueryResponse(puc.appointify.domain.core.entity.Schedule schedule) {
        var company = schedule.getEmployee().getCompany();
        var customer = schedule.getCustomerAssignee();
        var employee = schedule.getEmployee();
        var service = schedule.getOfferedService();

        return FindAppointmentQueryResponse
                .builder()
                .schedule(Schedule
                        .builder()
                        .id(schedule.getId())
                        .startDate(schedule.getScheduleDate().getStart())
                        .endDate(schedule.getScheduleDate().getEnd())
                        .build())
                .company(Company
                        .builder()
                        .id(company.getId())
                        .name(company.getCompanyDetails().getName())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .build())
                .customer(Customer
                        .builder()
                        .id(customer.getId())
                        .email(customer.getUser().getEmail().getValue())
                        .name(customer.getUser().getFullName())
                        .build())
                .employee(Employee
                        .builder()
                        .id(employee.getId())
                        .name(employee.getUser().getFullName())
                        .build())
                .service(Service
                        .builder()
                        .id(service.getId())
                        .name(service.getName())
                        .description(service.getDescription())
                        .price(service.getPrice().getAmount())
                        .build())
                .build();
    }


    public FindAvailableSchedulesQueryResponse scheduleToFindAvailableSchedulesQueryResponse(puc.appointify.domain.core.entity.Schedule schedule) {
        var company = schedule.getEmployee().getCompany();
        var customer = schedule.getCustomerAssignee();
        var employee = schedule.getEmployee();
        var service = schedule.getOfferedService();

        return FindAvailableSchedulesQueryResponse
                .builder()
                .schedule(Schedule
                        .builder()
                        .id(schedule.getId())
                        .startDate(schedule.getScheduleDate().getStart())
                        .endDate(schedule.getScheduleDate().getEnd())
                        .build())
                .company(Company
                        .builder()
                        .id(company.getId())
                        .name(company.getCompanyDetails().getName())
                        .governmentId(company.getCompanyDetails().getGovernmentId())
                        .build())
                .employee(Employee
                        .builder()
                        .id(employee.getId())
                        .name(employee.getUser().getFullName())
                        .build())
                .service(Service
                        .builder()
                        .id(service.getId())
                        .name(service.getName())
                        .description(service.getDescription())
                        .price(service.getPrice().getAmount())
                        .build())
                .build();
    }
}
