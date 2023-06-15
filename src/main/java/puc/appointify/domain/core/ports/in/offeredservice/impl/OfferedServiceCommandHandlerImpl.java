package puc.appointify.domain.core.ports.in.offeredservice.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.core.ports.out.repository.CompanyRepository;
import puc.appointify.domain.core.ports.out.repository.OfferedServiceRepository;
import puc.appointify.domain.core.ports.in.offeredservice.contract.command.CreateOfferedServiceCommand;
import puc.appointify.domain.core.ports.in.offeredservice.contract.command.CreateOfferedServiceCommandResponse;
import puc.appointify.domain.core.common.exception.NotFoundException;
import puc.appointify.domain.core.ports.in.offeredservice.mapper.OfferedServiceMapper;
import puc.appointify.domain.core.ports.in.offeredservice.OfferedServiceCommandHandler;

@Component
@RequiredArgsConstructor
public class OfferedServiceCommandHandlerImpl implements OfferedServiceCommandHandler {
    private final OfferedServiceMapper mapper;
    private final CompanyRepository companyRepository;
    private final OfferedServiceRepository repository;


    @Override
    public CreateOfferedServiceCommandResponse create(CreateOfferedServiceCommand command) {
        var company = companyRepository.findById(command.getCompanyId());
        if (company == null)
            throw new NotFoundException("not found registered company");

        var offeredService = mapper.createOfferedServiceCommandToOfferedService(command);
        offeredService.initialize(company);
        var saved = repository.save(offeredService);
        return mapper.offeredServiceToCreateOfferedServiceCommandResponse(saved);
    }
}
