package me.mrtoke.fbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//import java.util.Date;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.mrtoke.fbook.entities.Member;
import me.mrtoke.fbook.entities.Writer;
import me.mrtoke.fbook.services.MemberServices;
//@SpringBootApplication(scanBasePackages = { "the.package.name", "the.next.package.name" })
@SpringBootApplication
public class FbookApplication {
	
	@Autowired
	MemberServices userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(FbookApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			//String username, String firstName, String lastName, String email, String password
			for(int i=1; i<=20; i++) {
				Member jack = new Member("jackptoke" + i, "Jack" + i, "Toke" + i, "jackptoke" + i + "@gmail.com", "q09rua908jfa;sdkfj"+i);
				userService.save(jack);
			}
			for(int i=1; i<=20; i++) {
				Member amy = new Writer("amytoke" + i, "Amy" + i, "Toke" + i, "amyrtoke" + i + "@gmail.com", "q09rua908jfa;sdkfj"+i);
				userService.save(amy);
			}
			//User user, String message, String medialURL
		};
	}
}
