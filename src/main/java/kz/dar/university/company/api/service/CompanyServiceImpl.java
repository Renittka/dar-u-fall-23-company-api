package kz.dar.university.company.api.service;

import kz.dar.university.company.api.domain.Company;
import kz.dar.university.company.api.domain.CompanyDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private List<Company> companies = new ArrayList<>();

    {
        List<String> employees = new ArrayList();
        employees.add("1234");
        employees.add("123");

        Company darU = Company.builder()
                .id("dar-u")
                .name("DAR U")
                .employees(employees)
                .build();

        companies.add(darU);
    }

    @Override
    public Company getCompany(String id) {
        //return companies.get(id);
        return null;
    }

    @Override
    public List<Company> getCompanies() {
        return companies;
    }

    @Override
    public List<CompanyDetails> getCompaniesDetails() {
        return null;
    }
}
