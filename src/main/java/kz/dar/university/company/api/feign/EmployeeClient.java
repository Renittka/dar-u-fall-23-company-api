package kz.dar.university.company.api.feign;

import kz.dar.university.company.api.domain.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${feign.employee.core.api.name}")
public interface EmployeeClient {

    @GetMapping("/employee/{id}")
    EmployeeDTO getEmployeeById(
            @PathVariable String id
    );


    @GetMapping("/employee/list")
    List<EmployeeDTO> getEmployeesByList(
            @RequestParam List<String> employeeIds
    );

}
