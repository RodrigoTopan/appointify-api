package puc.appointify.domain.ports.in.user.contracts.query;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FindUserQuery {
    @NotEmpty
    private String username;
}

