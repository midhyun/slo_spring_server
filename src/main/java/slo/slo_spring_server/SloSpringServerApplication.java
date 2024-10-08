package slo.slo_spring_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SloSpringServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SloSpringServerApplication.class, args);
	}

}
