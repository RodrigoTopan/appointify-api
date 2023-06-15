package puc.appointify.domain.core.ports.in.company;

import puc.appointify.domain.core.ports.in.company.contract.command.CreateCompanyCommand;
import puc.appointify.domain.core.ports.in.company.contract.command.CreateCompanyCommandResponse;

import java.util.UUID;

public interface CompanyCommandHandler {
    CreateCompanyCommandResponse create(CreateCompanyCommand command);
    void deleteById(UUID id);
}
