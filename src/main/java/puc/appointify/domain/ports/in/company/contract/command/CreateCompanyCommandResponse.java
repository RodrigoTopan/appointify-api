package puc.appointify.domain.ports.in.company.contract.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import puc.appointify.domain.ports.in.company.contract.CompanyDTO;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCompanyCommandResponse {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private CompanyDTO company;
}