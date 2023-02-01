package puc.appointify.domain.ports.in.schedules.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class FindCustomerAppointmentsQuery {
    private UUID customerId;
}
