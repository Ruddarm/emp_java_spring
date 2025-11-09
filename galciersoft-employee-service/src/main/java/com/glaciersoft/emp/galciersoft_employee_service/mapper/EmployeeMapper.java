package com.glaciersoft.emp.galciersoft_employee_service.mapper;


import com.glaciersoft.emp.galciersoft_employee_service.dtos.EmployeeDto;
import com.glaciersoft.emp.galciersoft_employee_service.model.Employee;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEmployee(EmployeeDto employeeDto);
    EmployeeDto toEmployeeDto(Employee employee);
}
