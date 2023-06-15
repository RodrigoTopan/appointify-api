package puc.appointify.domain.core.ports.in.customer.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindCustomerQueryResponse {

    private UUID id;
    private UUID userId;
}
