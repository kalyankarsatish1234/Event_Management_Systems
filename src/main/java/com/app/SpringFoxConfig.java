package com.app; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;  
@Configuration  
//Enable Swagger  
@EnableSwagger2  
public class SpringFoxConfig   
{  
//creating bean  
@Bean  
public Docket api()  
{  
//creating constructor of Docket class that accepts parameter DocumentationType  
return new Docket(DocumentationType.SWAGGER_2);  
}  
}  