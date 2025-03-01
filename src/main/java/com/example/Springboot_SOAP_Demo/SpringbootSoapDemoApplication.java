package com.example.Springboot_SOAP_Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSoapDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSoapDemoApplication.class, args);
	}

}




/*

url to load - wsdl file  => http://localhost:9090/soap_Demo/employees.wsdl

Project Name -> Springboot-Soap-Demo-CRUP_OP

youtube link to study -> https://youtu.be/3I_-oRLTrHU?si=_fYVCembjPdTx4j9

Install SOAP-UI and give link of employees.wsdl for web-service request in xml,
	update request xml file and send request.
 */