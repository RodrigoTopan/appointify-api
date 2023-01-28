package puc.appointify.domain.ports.in;

import puc.appointify.domain.command.offeredService.CreateOfferedServiceCommand;
import puc.appointify.domain.command.offeredService.OfferedServiceResponse;

import java.util.List;

public interface CreateOfferedServiceCommandHandler {
    OfferedServiceResponse create(CreateOfferedServiceCommand command);

    List<OfferedServiceResponse> findAll();
}
