package puc.appointify.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.command.offeredservice.CreateOfferedServiceCommand;
import puc.appointify.domain.command.offeredservice.OfferedServiceResponse;
import puc.appointify.domain.common.exception.NotFoundException;
import puc.appointify.domain.mapper.OfferedServiceMapper;
import puc.appointify.domain.ports.in.OfferedServiceCommandHandler;
import puc.appointify.domain.ports.out.repository.CompanyRepository;
import puc.appointify.domain.ports.out.repository.OfferedServiceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OfferedServiceCommandHandlerImpl implements OfferedServiceCommandHandler {
    private final OfferedServiceMapper mapper;
    private final CompanyRepository companyRepository;
    private final OfferedServiceRepository repository;


    @Override
    public OfferedServiceResponse create(CreateOfferedServiceCommand command) {
        var companyAdmin = companyRepository.findById(command.getCompanyAdminId());
        if (companyAdmin == null)
            throw new NotFoundException("not found registered company");

        var offeredService = mapper.createOfferedServiceCommandToOfferedService(command);
        offeredService.initialize(companyAdmin);
        var saved = repository.save(offeredService);
        return mapper.offeredServiceToOfferedServiceResponse(saved);
    }

    @Override
    public List<OfferedServiceResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::offeredServiceToOfferedServiceResponse)
                .collect(Collectors.toList());
    }
}
