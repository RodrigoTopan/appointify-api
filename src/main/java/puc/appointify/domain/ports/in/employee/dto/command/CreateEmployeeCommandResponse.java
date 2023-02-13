package puc.appointify.domain.ports.in.employee.dto.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateEmployeeCommandResponse {

    private UUID id;
    private UUID userId;
    private UUID companyId;
}
