package kz.dar.university.company.api.service;

import kz.dar.university.company.api.domain.Company;
import kz.dar.university.company.api.domain.CompanyDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private HashMap<String, Company> companies = new HashMap();

    {
        List<String> employees = new ArrayList();
        employees.add("1234");
        employees.add("123");

        Company darU = Company.builder()
                .id("dar-u")
                .name("DAR U")
                .employees(employees)
                .build();

        companies.put(darU.getId(), darU);
    }

    @Override
    public Company getCompany(String id) {
        return companies.get(id);
    }

    @Override
    public List<Company> getCompanies() {
        return companies.values().stream().toList();
    }

    @Override
    public List<CompanyDetails> getCompaniesDetails() {
        return null;
    }
}
