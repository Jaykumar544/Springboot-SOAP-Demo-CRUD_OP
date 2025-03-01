package com.example.Springboot_SOAP_Demo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class SoapWebServiceConfig extends WsConfigurerAdapter
{
    @SuppressWarnings({"rawtypes","unchecked"})

    @Bean
    public ServletRegistrationBean messageDispatcherServletOperation(ApplicationContext applicationContext)
    {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(applicationContext);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet,"/soap_Demo/*");
    }

//    url to load - wsdl file for request format => http://localhost:9090/soap_Demo/employees.wsdl
    @Bean(name = "employees")
    public DefaultWsdl11Definition defaultWsdl11DefinitionOperation(XsdSchema xsdSchema)
    {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("DemoSoapServicePort");
        defaultWsdl11Definition.setLocationUri("/soap_Demo");
        defaultWsdl11Definition.setTargetNamespace("http://demo.com/springboot-soap-demo");
        defaultWsdl11Definition.setSchema(xsdSchema);
        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema employeeXsdSchema()
    {
        return new SimpleXsdSchema(new ClassPathResource("employee.xsd"));
    }
}

