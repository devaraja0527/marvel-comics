package com.marvel.comics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.marvel.comics.**")
public class MarvelComicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelComicsApplication.class, args);
	}

}
