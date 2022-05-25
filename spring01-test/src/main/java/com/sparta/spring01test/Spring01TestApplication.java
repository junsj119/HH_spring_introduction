package com.sparta.spring01test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Spring01TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring01TestApplication.class, args);
	}

}
