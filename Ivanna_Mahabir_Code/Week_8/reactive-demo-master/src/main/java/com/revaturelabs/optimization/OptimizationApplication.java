package com.revaturelabs.optimization;

import com.revaturelabs.optimization.batch.Batch;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class OptimizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptimizationApplication.class, args);
	}

}
