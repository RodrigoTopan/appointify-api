package puc.appointify.domain.ports.in.company.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.ports.in.company.contract.CompanyDTO;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class FindCompanyQueryResponse {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private CompanyDTO company;
}
