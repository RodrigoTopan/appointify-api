package puc.appointify.domain.ports.in;

import puc.appointify.domain.command.company.CreateCompanyAdminCommand;
import puc.appointify.domain.command.company.CreateCompanyAdminResponse;
import puc.appointify.domain.command.company.FindCompanyAdminResponse;

import java.util.List;
import java.util.UUID;

public interface CreateCompanyAdminCommandHandler {
    CreateCompanyAdminResponse createCompany(CreateCompanyAdminCommand command);

    List<FindCompanyAdminResponse> findAll();

    FindCompanyAdminResponse findById(UUID id);

    void deleteById(UUID id);
}
