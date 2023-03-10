package puc.appointify.domain.ports.in.offeredservice.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.domain.ports.in.offeredservice.contract.query.FindCompanyOfferedServicesQuery;
import puc.appointify.domain.ports.in.offeredservice.contract.query.FindOfferedServiceQueryResponse;
import puc.appointify.domain.ports.in.offeredservice.mapper.OfferedServiceMapper;
import puc.appointify.domain.ports.in.offeredservice.OfferedServiceQueryHandler;
import puc.appointify.domain.ports.out.repository.OfferedServiceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OfferedServiceQueryHandlerImpl implements OfferedServiceQueryHandler {
    private final OfferedServiceMapper mapper;
    private final OfferedServiceRepository repository;

    @Override
    public List<FindOfferedServiceQueryResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::offeredServiceToFindOfferedServiceQueryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FindOfferedServiceQueryResponse> find(FindCompanyOfferedServicesQuery query) {
        return repository.findAll()
                .stream()
                .map(mapper::offeredServiceToFindOfferedServiceQueryResponse)
                .collect(Collectors.toList());
    }
}
