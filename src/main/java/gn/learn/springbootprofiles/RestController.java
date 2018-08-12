package gn.learn.springbootprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	BasicConfiguration configuration;

	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		return welcomeMessage;	
	}
	
	@RequestMapping("/dynamic-configuration")
	public String dynamicConfiguration() {
		//not a good practice to use map 
		String dynamicMessage = " Message = "+configuration.getMessage()+
				"; Number = "+ configuration.getNumber()+"; Key = "+ configuration.isValue();
		return dynamicMessage;
	}
}
