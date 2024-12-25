package com.jsp.prc.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SawggerConfig {

	@Bean
	public OpenAPI usersMicroserviceOpenAPI() {
		
		Server localHost=new Server();
		localHost.setUrl("http://localhost:8058");
		localHost.setDescription("Development environment");
		
		Contact contact=new Contact();
		contact.setName("Mohammed Mustafa");
		contact.setEmail("mdrmustafa@gmail.com");
		contact.setName("https://emp.com");
		
		License license = new License();
		license.setName("MIT License");
		license.setUrl("https://choosealicense.com/licenses/mit/");
		
		Info info = new Info();
		info.setTitle("employee_management_System RESTful Web Service documentation");
		info.setVersion("1.0");
		info.contact(contact);
		info.setDescription("This API exposes endpoints to manage Application.");
		info.setLicense(license);
		info.setTermsOfService("https://domainname/terms");
		
		return  new OpenAPI().info(info).servers(List.of(localHost));
		
	}

}
