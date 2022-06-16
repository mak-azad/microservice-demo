package br.com.brandao.welcome.controllers;


import java.util.Random;
import java.util.UUID;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import main.java.br.com.brandao.welcome.entity.Student;

@RestController
@RequestMapping(path = "/welcome")
public class WelcomeController {
	String [] nameList = {"Md Abul Kalam Azad", "Probir Roy", "SSM Tariq", "Nafees", "Shimul"};
	Random rand = new Random();
	int idx = rand.nextInt(5);
	String name = nameList[idx];
	int age = rand.nextInt(30) + 10;
	UUID id = UUID.randomUUID();
	Date dob = new Date();
	
	
	// send whole object
	@GetMapping(path = "/rpc1")
	public Student getWelcomeObject() {
		Student stObject = new Student(name, age, id, dob);
		return stObject;
	}
	//send only a field
	@GetMapping(path = "/rpc2")
	public String getWelcomeAge() {
		Student stObject = new Student(name, age, id, dob);
		return stObject.getName();
	}

}
