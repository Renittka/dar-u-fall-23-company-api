package kz.dar.university.company.api.service;

import kz.dar.university.company.api.domain.Company;
import kz.dar.university.company.api.domain.CompanyDetails;

import java.util.List;

public interface CompanyService {

    Company getCompany(String id);

    CompanyDetails getCompanyWithDetails(String id);

    List<Company> getCompanies();

    List<CompanyDetails> getCompaniesDetails();

    List<CompanyDetails> getCompaniesDetailsByEmployeeIdList();

}
