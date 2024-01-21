package kz.dar.university.company.api.controller;

import kz.dar.university.company.api.domain.Company;
import kz.dar.university.company.api.domain.CompanyDetails;
import kz.dar.university.company.api.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/all")
    public List<Company> getAllCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping("/detail")
    public List<CompanyDetails> getAllCompaniesWithDetails(){
        return companyService.getCompaniesDetails();
    }

}
