package io.github.humbertoluiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


//@EnableFeignClients
@SpringBootApplication
public class VendasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasApiApplication.class, args);
	}

}
