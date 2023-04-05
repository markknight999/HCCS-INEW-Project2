package edu.hccs.myspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class MyspringApplication {

	private static void extracted(ConfigurableApplicationContext context) throws IOException {

		StudentController studentController = context.getBean(StudentController.class);

	}

	public static void main(String[] args) throws IOException {

		ConfigurableApplicationContext context = SpringApplication.run(MyspringApplication.class, args);
		extracted(context);

	}

}
