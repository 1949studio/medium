package me.mrtoke.fbook;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import me.mrtoke.fbook.dao.IPostRepository;
import me.mrtoke.fbook.dao.IUserRepository;
import me.mrtoke.fbook.entities.User;

@SpringBootTest
//@ContextConfiguration(classes=FbookApplication.class)
@RunWith(SpringRunner.class)
//@DataJpaTest
//@SqlGroup( @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts= {"classpath:schema.sql", "classpath:data.sql"}))
class FbookApplicationTests {

	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	IPostRepository postRepo;
	
	@Test
	void ifNewUserSaved_ThenSuccess() {
		User newUser = new User("jeremiahtoke", "Jeremiah", "Toke", "jeremiahtoke@gmail.com", "alksdjflaskdj");
		List<User> users = userRepo.findAll();
		
		for( User user : users) {
			System.out.println(user.getUsername());
		}
		
		int countBefore = users.size();
		System.out.println("Count before: " + countBefore);
		userRepo.save(newUser);
		int countAfter = userRepo.findAll().size();
		System.out.println("Count after: " + countAfter);
		assertEquals(countBefore + 1, countAfter);
	}

}
