package com.mindex.challenge;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.impl.ReportingStructureImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@GetMapping
	public String hello(){

		return "help me";
	}
}
