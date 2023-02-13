package puc.appointify.domain.ports.in.offeredservice.dto.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FindCompanyOfferedServicesQuery {
    private UUID companyId;
}

