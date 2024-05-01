package relucky.code.service;

import relucky.code.model.entity.Company;

import java.util.List;

public interface CompanyService {
    void save(Company company);

    List<Company> getAll();

}
