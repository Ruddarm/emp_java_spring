package com.glaciersoft.emp.galciersoft_employee_service.controllers;


import com.glaciersoft.emp.galciersoft_employee_service.dtos.EmployeeDto;
import com.glaciersoft.emp.galciersoft_employee_service.exceptions.EmployeeNotFound;
import com.glaciersoft.emp.galciersoft_employee_service.mapper.EmployeeMapper;
import com.glaciersoft.emp.galciersoft_employee_service.model.Employee;
import com.glaciersoft.emp.galciersoft_employee_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @PostMapping()
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeMapper.toEmployeeDto(employeeService.saveEmployee(employeeMapper.toEmployee(employeeDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok(employeeMapper.toEmployeeDto(employeeService.getEmployeeById(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getEmployeeList() {
        return ResponseEntity.ok(employeeService
                .allEmployee()
                .stream().map(employeeMapper::toEmployeeDto)
                .toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        if (!employeeService.DeleteById(id)) throw new EmployeeNotFound("Employee not found with Id ", id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-salary")
    public ResponseEntity<EmployeeDto> updateSalary(@RequestParam long id, @RequestParam long salary) {
        return ResponseEntity.ok(employeeMapper.toEmployeeDto(employeeService.updateSalaryById(id, salary)));
    }

    @GetMapping("/avg-salary")
    public ResponseEntity<Map<String, Double>> getAvgSalaryByDpt() {
        return ResponseEntity.ok(employeeService.avgSalaryPerDepartment());
    }

    @GetMapping("/highest-salary")
    public ResponseEntity<EmployeeDto> getHighestPaidEmployee() {
        return ResponseEntity.ok(
                employeeMapper.toEmployeeDto(
                        employeeService.highestPaidEmployee()
                ));
    }


    @GetMapping("/above-average")
    public ResponseEntity<List<EmployeeDto>> aboveAverage() {
        return ResponseEntity.ok(employeeService.employeeAboveAvg());
    }
}
