package com.glaciersoft.emp.galciersoft_employee_service.dtos;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto{
    private  long Id;
    private  String name;
    private  double salary;
    private  String department;
}
