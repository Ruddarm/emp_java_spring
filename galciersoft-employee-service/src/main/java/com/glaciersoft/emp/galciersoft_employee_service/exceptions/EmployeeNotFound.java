package com.glaciersoft.emp.galciersoft_employee_service.exceptions;

public class EmployeeNotFound extends RuntimeException {
    private long id;
    public EmployeeNotFound(String message,long id) {
        super(message);
        this.id=id;
    }

    public EmployeeNotFound(String msg){
        super(msg);
    }
}
