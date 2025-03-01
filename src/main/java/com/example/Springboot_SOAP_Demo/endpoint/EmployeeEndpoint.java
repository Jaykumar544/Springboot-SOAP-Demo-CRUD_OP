package com.example.Springboot_SOAP_Demo.endpoint;

import com.demo.springboot_soap_demo.*;
import com.example.Springboot_SOAP_Demo.entities.Employee;
import com.example.Springboot_SOAP_Demo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeEndpoint
{
    private static final String NAMESPACE_URI = "http://demo.com/springboot-soap-demo";

    @Autowired
    private EmployeeService employeeService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
    @ResponsePayload
    public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request)
    {
        return employeeService.addEmployee(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request)
    {
        return employeeService.getEmployeeById(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
    @ResponsePayload
    public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request)
    {
        Employee employee = new Employee();
        BeanUtils.copyProperties(request.getEmployeeInfo(),employee);
        employeeService.updateEmployee(employee);

        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatus("Success");
        serviceStatus.setMessage("Content Update Successfully");
        UpdateEmployeeResponse response = new UpdateEmployeeResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
    @ResponsePayload
    public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request)
    {
        employeeService.deleteEmployee(request.getEmployeeId());
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatus("Success");
        serviceStatus.setMessage("Content Deleted Successfully");
        DeleteEmployeeResponse response = new DeleteEmployeeResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
}
