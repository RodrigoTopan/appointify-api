package puc.appointify.domain.command.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.command.company.dto.CompanyDTO;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class FindCompanyAdminResponse {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private CompanyDTO company;
}
