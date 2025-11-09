package com.glaciersoft.emp.galciersoft_employee_service.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    private Long id;
    private String name;
    private double salary;
    private String department;
}
