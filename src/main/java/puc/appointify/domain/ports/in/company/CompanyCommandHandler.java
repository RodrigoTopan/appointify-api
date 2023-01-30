package puc.appointify.domain.ports.in.company;

import puc.appointify.domain.ports.in.company.contract.command.CreateCompanyCommand;
import puc.appointify.domain.ports.in.company.contract.command.CreateCompanyCommandResponse;

import java.util.UUID;

public interface CompanyCommandHandler {
    CreateCompanyCommandResponse createCompany(CreateCompanyCommand command);
    void deleteById(UUID id);
}
