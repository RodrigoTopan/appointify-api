package puc.appointify.domain.core.ports.in.employee.contract.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import puc.appointify.domain.core.entity.Schedule;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeCommandResponse {

    private UUID id;
    private UUID userId;
    private UUID companyId;
}
