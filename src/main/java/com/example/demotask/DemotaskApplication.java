package com.example.demotask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class DemotaskApplication {

int adds =0;
String newWord = "SarsenovaM";

	public static void main(String[] args) {
		SpringApplication.run(DemotaskApplication.class, args);
	}


}
