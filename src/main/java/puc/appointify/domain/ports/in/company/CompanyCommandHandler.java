package puc.appointify.domain.ports.in.company;

import puc.appointify.domain.ports.in.company.dto.command.CreateCompanyCommand;
import puc.appointify.domain.ports.in.company.dto.command.CreateCompanyCommandResponse;

import java.util.UUID;

public interface CompanyCommandHandler {
    CreateCompanyCommandResponse create(CreateCompanyCommand command);
    void deleteById(UUID id);
}
