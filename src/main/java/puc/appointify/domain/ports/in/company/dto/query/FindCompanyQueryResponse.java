package puc.appointify.domain.ports.in.company.dto.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.ports.in.company.dto.Company;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class FindCompanyQueryResponse {

    private UUID id;
    private UUID userId;
    private Company company;
}
