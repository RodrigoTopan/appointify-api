package puc.appointify.domain.core.ports.in.offeredservice.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindCompanyOfferedServicesQuery {
    private UUID companyId;
}

