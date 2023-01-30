package puc.appointify.domain.ports.in.offeredservice;

import puc.appointify.domain.ports.in.offeredservice.contract.command.CreateOfferedServiceCommand;
import puc.appointify.domain.ports.in.offeredservice.contract.command.CreateOfferedServiceCommandResponse;

public interface OfferedServiceCommandHandler {
    CreateOfferedServiceCommandResponse create(CreateOfferedServiceCommand command);
}
