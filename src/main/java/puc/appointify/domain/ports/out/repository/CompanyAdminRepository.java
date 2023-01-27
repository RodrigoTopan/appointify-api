package puc.appointify.domain.ports.out.repository;

import puc.appointify.domain.core.entity.CompanyAdmin;

import java.util.List;
import java.util.UUID;

public interface CompanyAdminRepository {
    CompanyAdmin save(CompanyAdmin customer);

    List<CompanyAdmin> findAll();

    CompanyAdmin findById(UUID id);

    void deleteById(UUID id);
}
