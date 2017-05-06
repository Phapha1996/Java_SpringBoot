package org.fage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@EnableWebMvc
@SpringBootApplication(scanBasePackages = {"org.fage"})
public class App {
	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
}

