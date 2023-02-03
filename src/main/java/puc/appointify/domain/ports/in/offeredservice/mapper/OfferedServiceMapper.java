package puc.appointify.domain.ports.in.offeredservice.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.core.entity.OfferedService;
import puc.appointify.domain.core.entity.valueobject.Money;
import puc.appointify.domain.ports.in.offeredservice.contract.command.CreateOfferedServiceCommand;
import puc.appointify.domain.ports.in.offeredservice.contract.command.CreateOfferedServiceCommandResponse;
import puc.appointify.domain.ports.in.offeredservice.contract.query.FindOfferedServiceQueryResponse;

@Component
public class OfferedServiceMapper {
    public OfferedService createOfferedServiceCommandToOfferedService(CreateOfferedServiceCommand command) {
        return OfferedService
                .builder()
                .name(command.getName())
                .description(command.getDescription())
                .price(new Money(command.getPrice()))
                .build();
    }

    public CreateOfferedServiceCommandResponse offeredServiceToCreateOfferedServiceCommandResponse(
            OfferedService offeredService) {
        return CreateOfferedServiceCommandResponse
                .builder()
                .id(offeredService.getId())
                .name(offeredService.getName())
                .companyId(offeredService.getCompany().getId())
                .description(offeredService.getDescription())
                .price(offeredService.getPrice().getAmount())
                .build();
    }

    public FindOfferedServiceQueryResponse offeredServiceToFindOfferedServiceQueryResponse(
            OfferedService offeredService) {
        return FindOfferedServiceQueryResponse
                .builder()
                .id(offeredService.getId())
                .name(offeredService.getName())
                .companyId(offeredService.getCompany().getId())
                .description(offeredService.getDescription())
                .price(offeredService.getPrice().getAmount())
                .build();
    }
}
