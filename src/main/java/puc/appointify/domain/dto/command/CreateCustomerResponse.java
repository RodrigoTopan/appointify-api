package puc.appointify.domain.dto.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCustomerResponse {

    private UUID id;
    private String name;
    private String email;
    private String password;
}
