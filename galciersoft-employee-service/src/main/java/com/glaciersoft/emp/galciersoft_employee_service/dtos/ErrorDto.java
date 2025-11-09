package com.glaciersoft.emp.galciersoft_employee_service.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {

    private String path;
    private  String msg;
    private  int status;
}
