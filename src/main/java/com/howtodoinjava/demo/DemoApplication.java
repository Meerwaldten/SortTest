package com.howtodoinjava.demo;

import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner importData(EmployeeRepository employeeRepository) {
		return (args) -> {

			final List<EmployeeEntity> customers = new ArrayList<>();
			customers.add(new EmployeeEntity("Simon Eriksen", "Swag", "SimonErSej@hej.dk"));
			customers.add(new EmployeeEntity("Asger zando", "Slacker", "Zandoservice@hej.dk"));
			customers.add(new EmployeeEntity("Johannes", "Hejsa", "skrdr@hej.dk"));
			customers.add(new EmployeeEntity("Jens", "Politiken", "politiken@hej.dk"));
			customers.add(new EmployeeEntity("Mads", "Yo", "kea@hej.dk"));
			employeeRepository.saveAll(customers);

			log.info("Data import done");
		};
	}


}
