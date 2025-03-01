package com.example.Springboot_SOAP_Demo.entities;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@ToString
@Document(collection = "employee")
public class Employee
{
    @Id
    @Field(name = "employee_id")
    private String employeeId;

    private String name;
    private String department;
    private String phone;
    private String address;

}
