package puc.appointify.domain.ports.in.schedules.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.ports.in.schedules.contract.CompanyDTO;
import puc.appointify.domain.ports.in.schedules.contract.EmployeeDTO;
import puc.appointify.domain.ports.in.schedules.contract.ScheduleDTO;
import puc.appointify.domain.ports.in.schedules.contract.ServiceDTO;

@Getter
@Builder
@AllArgsConstructor
public class FindAvailableSchedulesQueryResponse {
    private ScheduleDTO schedule;
    private ServiceDTO service;
    private EmployeeDTO employee;
    private CompanyDTO company;
}
