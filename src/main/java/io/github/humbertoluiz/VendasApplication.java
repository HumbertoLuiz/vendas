package io.github.humbertoluiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class VendasApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
