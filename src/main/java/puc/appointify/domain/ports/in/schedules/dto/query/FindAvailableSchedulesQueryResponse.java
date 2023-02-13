package puc.appointify.domain.ports.in.schedules.dto.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.ports.in.schedules.dto.Company;
import puc.appointify.domain.ports.in.schedules.dto.Employee;
import puc.appointify.domain.ports.in.schedules.dto.Schedule;
import puc.appointify.domain.ports.in.schedules.dto.Service;

@Getter
@Builder
@AllArgsConstructor
public class FindAvailableSchedulesQueryResponse {
    private Schedule schedule;
    private Service service;
    private Employee employee;
    private Company company;
}
