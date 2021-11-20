package me.mrtoke.fbook;

//import java.util.Date;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.mrtoke.fbook.dao.IPostRepository;
import me.mrtoke.fbook.dao.IUserRepository;
import me.mrtoke.fbook.entities.Post;
import me.mrtoke.fbook.entities.User;
//@SpringBootApplication(scanBasePackages = { "the.package.name", "the.next.package.name" })
@SpringBootApplication
public class FbookApplication {
	/*
	@Autowired
	IUserRepository userRepo;
	@Autowired
	IPostRepository postRepo;*/
	
	public static void main(String[] args) {
		SpringApplication.run(FbookApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner runner() {
		return args -> {
			//String username, String firstName, String lastName, String email, String password
			User jack = new User("jackptoke", "Jack", "Toke", "jackptoke@gmail.com", "q09rua908jfa;sdkfj");
			User amy = new User("amyrtoke", "Amy", "Toke", "amytoke@gmail.com", "poiawjr;laskfjasdf");
			userRepo.save(jack);
			userRepo.save(amy);
			
			//User user, String message, String medialURL
			Post post1 = new Post(jack, "Greeting from Australia", "https://files.worldwildlife.org/wwfcmsprod/images/Polar_bear_on_ice_in_Svalbard_Norway_WW294883/hero_small/85px6g3dhv_Polar_bear_on_ice_in_Svalbard_Norway_WW294883.jpg");
			Post post2 = new Post(amy, "Greeting from Charlton", "https://files.worldwildlife.org/wwfcmsprod/images/Polar_bear_on_ice_in_Svalbard_Norway_WW294883/hero_small/85px6g3dhv_Polar_bear_on_ice_in_Svalbard_Norway_WW294883.jpg");
			post1.setCreatedTime(new Date(System.currentTimeMillis()));
			post2.setCreatedTime(new Date(System.currentTimeMillis()));
			postRepo.save(post1);
			postRepo.save(post2);
		};
	}*/
}
