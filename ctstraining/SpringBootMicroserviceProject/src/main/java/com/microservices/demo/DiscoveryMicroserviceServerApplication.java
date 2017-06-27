package com.microservices.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaServer
@RestController
public class DiscoveryMicroserviceServerApplication {

	
//	http://localhost:1111/hello
	@RequestMapping("/hello")
	public String welcomeUser(){	
		return "Welcome user";
	}

//	http://localhost:1111/welcome?name=arti	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String welcomeUser(@RequestParam("name") String name){	
		return "Welcome "+name;
	}
	
	@RequestMapping(value="/items", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getItemsJson(){
		List<String> list = new ArrayList<>();
		list.add("Mobile");
		list.add("Laptop");
		list.add("Watch");		
		return list;
	}

	@RequestMapping(value="/products", method=RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public List<String> getProductsXml(){
		List<String> list = new ArrayList<>();
		list.add("Mobile");
		list.add("Laptop");
		list.add("Watch");		
		return list;
	}


	
	public static void main(String[] args) {
		SpringApplication.run(DiscoveryMicroserviceServerApplication.class, args);
	}
}
