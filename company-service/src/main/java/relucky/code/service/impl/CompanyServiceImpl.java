package relucky.code.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import relucky.code.model.entity.Company;
import relucky.code.repository.CompanyRepository;
import relucky.code.service.CompanyService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public void save(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> getAll() {
        return (List<Company>) companyRepository.findAll();
    }
}
