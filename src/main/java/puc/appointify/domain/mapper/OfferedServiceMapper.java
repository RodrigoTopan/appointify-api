package puc.appointify.domain.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.command.offeredservice.CreateOfferedServiceCommand;
import puc.appointify.domain.command.offeredservice.OfferedServiceResponse;
import puc.appointify.domain.core.entity.OfferedService;
import puc.appointify.domain.core.entity.valueobject.Money;

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

    public OfferedServiceResponse offeredServiceToOfferedServiceResponse(OfferedService offeredService) {
        return OfferedServiceResponse
                .builder()
                .id(offeredService.getId())
                .name(offeredService.getName())
                .companyAdminId(offeredService.getCompany().getId())
                .description(offeredService.getDescription())
                .price(offeredService.getPrice().getAmount())
                .build();
    }
}
