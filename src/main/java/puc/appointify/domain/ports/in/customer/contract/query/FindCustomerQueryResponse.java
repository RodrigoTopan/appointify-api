package puc.appointify.domain.ports.in.customer.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class FindCustomerQueryResponse {

    private UUID id;
    private UUID userId;
}
