package com.datadawgs.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * This is the class containing the main method running the rest of our code
 */
@SpringBootApplication
public class Dbx370TermProjectApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Dbx370TermProjectApplication.class, args);
		}

}
