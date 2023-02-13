package puc.appointify.domain.ports.in.offeredservice.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.offeredservice.dto.command.CreateOfferedServiceCommand;
import puc.appointify.domain.ports.in.offeredservice.dto.command.CreateOfferedServiceCommandResponse;
import puc.appointify.domain.core.common.exception.NotFoundException;
import puc.appointify.domain.ports.in.offeredservice.mapper.OfferedServiceMapper;
import puc.appointify.domain.ports.in.offeredservice.OfferedServiceCommandHandler;
import puc.appointify.domain.ports.out.repository.CompanyRepository;
import puc.appointify.domain.ports.out.repository.OfferedServiceRepository;

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
