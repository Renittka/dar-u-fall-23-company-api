package kz.dar.university.company.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {

    private String id;
    private String name;
    private String surname;
    private String department;
    private String position;
    private String email;
    private double salary;

}
