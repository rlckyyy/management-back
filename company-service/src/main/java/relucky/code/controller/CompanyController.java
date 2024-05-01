package relucky.code.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import relucky.code.model.entity.Company;
import relucky.code.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    void saveCompany(@RequestBody Company company){
        companyService.save(company);
    }
    @GetMapping
    List<Company> getAll(){
        return companyService.getAll();
    }
}
