package puc.appointify.domain.core.ports.in.offeredservice;

import puc.appointify.domain.core.ports.in.offeredservice.contract.command.CreateOfferedServiceCommand;
import puc.appointify.domain.core.ports.in.offeredservice.contract.command.CreateOfferedServiceCommandResponse;

public interface OfferedServiceCommandHandler {
    CreateOfferedServiceCommandResponse create(CreateOfferedServiceCommand command);
}
