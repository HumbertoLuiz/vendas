package io.github.humbertoluiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class VendasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasApiApplication.class, args);
	}

}
