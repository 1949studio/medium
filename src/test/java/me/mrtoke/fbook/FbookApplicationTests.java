package me.mrtoke.fbook;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import me.mrtoke.fbook.dao.IMemberRepository;
import me.mrtoke.fbook.entities.Member;

@SpringBootTest
//@ContextConfiguration(classes=FbookApplication.class)
@RunWith(SpringRunner.class)
//@DataJpaTest
//@SqlGroup( @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts= {"classpath:schema.sql", "classpath:data.sql"}))
class FbookApplicationTests {

	@Autowired
	IMemberRepository userRepo;
	
	
	@Test
	void ifNewUserSaved_ThenSuccess() {
		Member newUser = new Member("jeremiahtoke", "Jeremiah", "Toke", "jeremiahtoke@gmail.com", "alksdjflaskdj");
		List<Member> users = userRepo.findAll();
		
		for( Member user : users) {
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
