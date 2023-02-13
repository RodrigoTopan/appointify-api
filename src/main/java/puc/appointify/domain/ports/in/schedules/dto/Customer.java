package puc.appointify.domain.ports.in.schedules.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class Customer {
    private UUID id;
    private String name;
    private String email;
}
