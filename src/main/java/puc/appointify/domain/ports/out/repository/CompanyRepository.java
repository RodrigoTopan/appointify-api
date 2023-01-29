package puc.appointify.domain.ports.out.repository;

import puc.appointify.domain.core.entity.Company;

import java.util.List;
import java.util.UUID;

public interface CompanyRepository {
    Company save(Company customer);

    List<Company> findAll();

    Company findById(UUID id);

    void deleteById(UUID id);
}
