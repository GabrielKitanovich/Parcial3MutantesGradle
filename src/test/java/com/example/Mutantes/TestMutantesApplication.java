package com.example.Mutantes;

import org.springframework.boot.SpringApplication;

public class TestMutantesApplication {

	public static void main(String[] args) {
		SpringApplication.from(MutantesApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
