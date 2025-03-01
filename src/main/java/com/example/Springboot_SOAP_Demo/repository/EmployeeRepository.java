package com.example.Springboot_SOAP_Demo.repository;

import com.example.Springboot_SOAP_Demo.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String>
{ }
