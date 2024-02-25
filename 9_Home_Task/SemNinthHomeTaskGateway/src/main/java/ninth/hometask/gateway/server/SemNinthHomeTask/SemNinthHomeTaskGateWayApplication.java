package ninth.hometask.gateway.server.SemNinthHomeTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SemNinthHomeTaskGateWayApplication {
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route("MyUsers", r -> r.path("/users/**")
						.uri("http://localhost:8000"))
				.route("Accounts", r -> r.path("/**")
						.uri("http://localhost:7000")).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SemNinthHomeTaskGateWayApplication.class, args);
	}

}
