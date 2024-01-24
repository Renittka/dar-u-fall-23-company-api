package kz.dar.university.company.api.service;

import kz.dar.university.company.api.domain.Company;
import kz.dar.university.company.api.domain.CompanyDetails;
import kz.dar.university.company.api.domain.EmployeeDTO;
import kz.dar.university.company.api.feign.EmployeeClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private final EmployeeClient employeeClient;

    private HashMap<String, Company> companies = new HashMap();

    {
        List<String> employees = new ArrayList();
        employees.add("1234");
        employees.add("123");

        Company darU = Company.builder()
                .id("dar-u")
                .name("DAR U")
                .employeeIds(employees)
                .build();

        List<String> employees2 = new ArrayList<>();
        employees2.add("1234");
        employees2.add("3567896");

        Company kolesa = Company.builder()
                .id(UUID.randomUUID().toString())
                .name("kolesa")
                .employeeIds(employees2)
                .build();

        companies.put(darU.getId(), darU);
        companies.put(kolesa.getId(), kolesa);
    }

    @Override
    public Company getCompany(String id) {
        return companies.get(id);
    }

    @Override
    public CompanyDetails getCompanyWithDetails(String id) {
        // Get company by id
        Company company = companies.get(id);

        log.info("Company: " + company);

        // Get employees info
        List<String> employeeIds = company.getEmployeeIds();

        log.info("Employee ids: " + employeeIds);

        List<EmployeeDTO> employees = employeeClient.getEmployeesByList(employeeIds);

        log.info("Employees: " + employees);
        // Make result response
        CompanyDetails companyDetails = CompanyDetails
                .builder()
                .name(company.getName())
                .employees(employees)
                .build();

        log.info("Details: " + companyDetails);

        return companyDetails;
    }

    @Override
    public List<Company> getCompanies() {
        return companies.values().stream().toList();
    }

    @Override
    public List<CompanyDetails> getCompaniesDetails() {
        // Retrieve all companies
        //List<Company> companyList = companies.values().stream().toList();

        return companies
                .values()
                .stream()
                .map(
                        company -> {
                            // Get employee info by id
                            List<String> employeeIds = company.getEmployeeIds();
                            List<EmployeeDTO> employees = new ArrayList<>();
                            employeeIds.forEach(
                                    employeeId -> {
                                        EmployeeDTO employee = employeeClient.getEmployeeById(employeeId);

                                        if (employee != null) {
                                            employees.add(employee);
                                        }

                                    }
                            );

                            return CompanyDetails
                                    .builder()
                                    .name(company.getName())
                                    .employees(employees)
                                    .build();
                            //return new Company();
                        }
                )
                .toList();
    }

    @Override
    public List<CompanyDetails> getCompaniesDetailsByEmployeeIdList() {
        return companies
                .values()
                .stream()
                .map(
                        company -> {
                            // Get employee info by id
                            List<String> employeeIds = company.getEmployeeIds();
                            List<EmployeeDTO> employees = employeeClient.getEmployeesByList(employeeIds);

                            return CompanyDetails
                                    .builder()
                                    .name(company.getName())
                                    .employees(employees)
                                    .build();
                        }
                )
                .toList();
    }
}
