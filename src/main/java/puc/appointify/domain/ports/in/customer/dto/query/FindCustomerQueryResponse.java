package puc.appointify.domain.ports.in.customer.dto.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class FindCustomerQueryResponse {

    private UUID id;
    private String name;
    private String email;
    private String password;
}
