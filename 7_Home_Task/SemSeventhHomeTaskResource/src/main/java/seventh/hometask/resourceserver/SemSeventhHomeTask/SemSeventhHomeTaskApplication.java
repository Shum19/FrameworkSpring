package seventh.hometask.resourceserver.SemSeventhHomeTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class SemSeventhHomeTaskApplication {
//	@Bean
//	public CommonsRequestLoggingFilter logFilter() {
//		CommonsRequestLoggingFilter filter
//				= new CommonsRequestLoggingFilter();
//		filter.setIncludeQueryString(true);
//		filter.setIncludePayload(true);
//		filter.setMaxPayloadLength(10000);
//		filter.setIncludeHeaders(false);
//		filter.setAfterMessagePrefix("REQUEST DATA : ");
//		return filter;
//	}
	public static void main(String[] args) {
		SpringApplication.run(SemSeventhHomeTaskApplication.class, args);
	}

}
