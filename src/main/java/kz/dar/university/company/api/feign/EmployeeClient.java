package kz.dar.university.company.api.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "employee-core-api")
public class EmployeeClient {

}
