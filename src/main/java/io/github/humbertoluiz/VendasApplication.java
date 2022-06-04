package io.github.humbertoluiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@SpringBootApplication
@ComponentScan({"io.github.humbertoluiz.service.BeerService, io.github.humbertoluiz.mapper.BeerMapper, io.github.humbertoluiz.api.controller.BeerController"}) 
public class VendasApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
