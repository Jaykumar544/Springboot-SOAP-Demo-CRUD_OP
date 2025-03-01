package com.example.Springboot_SOAP_Demo.service;

import com.demo.springboot_soap_demo.*;
import com.example.Springboot_SOAP_Demo.config.EmployeeHelper;
import com.example.Springboot_SOAP_Demo.config.EmployeeServiceInterface;
import com.example.Springboot_SOAP_Demo.entities.Employee;
import com.example.Springboot_SOAP_Demo.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface
{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeHelper employeeHelper;


    @Override
    public AddEmployeeResponse addEmployee(AddEmployeeRequest request) {

        Employee employee = employeeHelper.prepareEmployeeModel(request);
        employeeRepository.save(employee);

        AddEmployeeResponse response = new AddEmployeeResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Added Successfully");
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public GetEmployeeResponse getEmployeeById(GetEmployeeRequest request)
    {
        Employee employee=null;
        Optional<Employee> optionalEmployee = employeeRepository.findById(request.getEmployeeInfo().getEmployeeId());
        if(optionalEmployee.isPresent())
            employee = optionalEmployee.get();

        GetEmployeeResponse response = new GetEmployeeResponse();
        EmployeeInfo employeeInfo = new EmployeeInfo();
        BeanUtils.copyProperties(employee,employeeInfo);
        response.setEmployeeInfo(employeeInfo);
        return response;
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
