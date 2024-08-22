package jmgomez.apipolicy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiPolicyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPolicyApplication.class, args);
	}

}
