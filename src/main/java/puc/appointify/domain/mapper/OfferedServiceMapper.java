package puc.appointify.domain.mapper;

import org.springframework.stereotype.Component;
import puc.appointify.domain.command.customer.CreateCustomerCommand;
import puc.appointify.domain.command.customer.CreateCustomerResponse;
import puc.appointify.domain.command.customer.FindCustomerResponse;
import puc.appointify.domain.command.offeredService.CreateOfferedServiceCommand;
import puc.appointify.domain.command.offeredService.OfferedServiceResponse;
import puc.appointify.domain.core.entity.Customer;
import puc.appointify.domain.core.entity.OfferedService;
import puc.appointify.domain.core.entity.valueobject.Email;
import puc.appointify.domain.core.entity.valueobject.Money;
import puc.appointify.domain.core.entity.valueobject.Password;
import puc.appointify.domain.core.entity.valueobject.Username;

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
                .companyAdminId(offeredService.getCompanyAdmin().getId())
                .description(offeredService.getDescription())
                .price(offeredService.getPrice().getAmount())
                .build();
    }
}
