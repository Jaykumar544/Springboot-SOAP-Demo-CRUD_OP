package com.example.Springboot_SOAP_Demo.config;

import com.demo.springboot_soap_demo.AddEmployeeRequest;
import com.example.Springboot_SOAP_Demo.entities.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EmployeeHelper
{
    public Employee prepareEmployeeModel(AddEmployeeRequest request)
    {
        Employee employee = new Employee();
        BeanUtils.copyProperties(request.getEmployeeInfo(),employee);
        return employee;
    }
}
