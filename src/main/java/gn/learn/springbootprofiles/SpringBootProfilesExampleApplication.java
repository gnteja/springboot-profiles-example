package gn.learn.springbootprofiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SpringBootProfilesExampleApplication {

	@Profile("dev")
	@Bean
	public String devBean() {
		return "Dev";
	}
	
	@Profile("prod")
	@Bean
	public String prodBean() {
		return "Prod";
	}
	
	public static void main(String[] args) {
		ApplicationContext context = 
				SpringApplication.run(SpringBootProfilesExampleApplication.class, args);
		
		for (String name : context.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}
}
