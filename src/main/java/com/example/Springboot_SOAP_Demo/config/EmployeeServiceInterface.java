package com.example.Springboot_SOAP_Demo.config;

import com.demo.springboot_soap_demo.AddEmployeeRequest;
import com.demo.springboot_soap_demo.AddEmployeeResponse;
import com.demo.springboot_soap_demo.GetEmployeeRequest;
import com.demo.springboot_soap_demo.GetEmployeeResponse;
import com.example.Springboot_SOAP_Demo.entities.Employee;

public interface EmployeeServiceInterface
{
    AddEmployeeResponse addEmployee(AddEmployeeRequest request);
    GetEmployeeResponse getEmployeeById(GetEmployeeRequest request);
    void updateEmployee(Employee employee);
    void deleteEmployee(String employeeId);

}
