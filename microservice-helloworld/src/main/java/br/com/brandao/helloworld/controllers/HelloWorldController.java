package br.com.brandao.helloworld.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import main.java.br.com.brandao.helloworld.entity.Student;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {
	
	@Autowired 
	private RestTemplate restTemplate;

	
	@GetMapping
	public String getHelloWorldMessage(@RequestParam("name") String name) {

		if (name.equals("rpc1")){
			Student welcomeTerm = restTemplate.getForObject("http://microservice-welcome/welcome/rpc1", Student.class); //String welcomeTerm = restTemplate.getForObject("http://localhost:8280/welcome", String.class);
		
			StringBuilder sb = new StringBuilder();
			//sb.append("\"microservice-helloworld\" received data:name ");
			sb.append("Calling: ");
			sb.append("\"" + name + "\"");
			//sb.append("\n");
			//sb.append(", called  \"microservice-welcome\" to retrieve the welcome message:  ");
			//sb.append("\"" + welcomeTerm + "\"");
			sb.append(" Returned the message to the client: \"");
			sb.append("  ");
			sb.append(welcomeTerm.getName());
			sb.append(" ");
			//sb.append(name);
			sb.append(String.valueOf(welcomeTerm.getAge()));
			sb.append(" ");
			sb.append(welcomeTerm.getId());
			sb.append(" ");
			sb.append(welcomeTerm.getDob());
		//	sb.append("Welcome to microservice-helloworld\"");
			return sb.toString();	
		}else if (name.equals("rpc2")){
			String welcomeTerm = restTemplate.getForObject("http://microservice-welcome/welcome/rpc2", String.class); //String welcomeTerm = restTemplate.getForObject("http://localhost:8280/welcome", String.class);
			return welcomeTerm;
		}
		else return "Wrong prams : failed!";	
	}
}
