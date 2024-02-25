package ninth.hometask.eureka.server.SemNinthHomeTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SemNinthHomeTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SemNinthHomeTaskApplication.class, args);
	}

}
