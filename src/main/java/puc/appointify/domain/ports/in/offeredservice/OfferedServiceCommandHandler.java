package puc.appointify.domain.ports.in.offeredservice;

import puc.appointify.domain.ports.in.offeredservice.dto.command.CreateOfferedServiceCommand;
import puc.appointify.domain.ports.in.offeredservice.dto.command.CreateOfferedServiceCommandResponse;

public interface OfferedServiceCommandHandler {
    CreateOfferedServiceCommandResponse create(CreateOfferedServiceCommand command);
}
