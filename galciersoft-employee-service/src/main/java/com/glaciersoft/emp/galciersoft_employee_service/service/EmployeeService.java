package com.glaciersoft.emp.galciersoft_employee_service.service;


import com.glaciersoft.emp.galciersoft_employee_service.dtos.EmployeeDto;
import com.glaciersoft.emp.galciersoft_employee_service.exceptions.EmployeeNotFound;
import com.glaciersoft.emp.galciersoft_employee_service.mapper.EmployeeMapper;
import com.glaciersoft.emp.galciersoft_employee_service.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployeeService {


    private final EmployeeMapper employeeMapper;
    private ArrayList<Employee> employees = new ArrayList<>();
    private final AtomicLong atomicLong = new AtomicLong(1);

    public Employee saveEmployee(Employee employee) {
        employee.setId(atomicLong.getAndIncrement());
        employees.add(employee);
        return employee;
    }

    public List<Employee> allEmployee() {
        return employees;
    }

    public Employee getEmployeeById(long id) throws EmployeeNotFound {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFound("Employee not found with id : "+id, id));
    }

    public boolean DeleteById(long id) {
        return employees.removeIf(e -> e.getId().equals(id));
    }

    public Employee updateSalaryById(long id, double newSalary) {
        Employee e = getEmployeeById(id);
        e.setSalary(newSalary);
        return e;
    }

    public Map<String, Double> avgSalaryPerDepartment() {
        return employees.stream()
                .collect(Collectors
                        .groupingBy(e -> e.getDepartment(),
                                Collectors.averagingDouble(e -> e.getSalary())
                        )
                );
    }

    public Employee highestPaidEmployee() throws  EmployeeNotFound {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(()->new EmployeeNotFound("Employee Not Found"));
    }

    public List<EmployeeDto> employeeAboveAvg() {
        double avg = employees.stream().mapToDouble(e -> e.getSalary()).average().orElse(0);
        return employees.stream()
                .filter(e -> e.getSalary() > avg)
                .map(e -> employeeMapper.toEmployeeDto(e))
                .toList();

    }
}

