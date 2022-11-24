package s22.PhoneStore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import s22.PhoneStore.domain.Condition;
import s22.PhoneStore.domain.Phone;
import s22.PhoneStore.domain.PhoneRepository;

@DataJpaTest
class RepositoryTests {

	@Autowired
	PhoneRepository phoneRepository;
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void findPhonesConditionShouldReturnOneCondition() {
		// Haetaan teityn puhelimen kunto
		// Tiedetään puhelimen Id ja kunto
		
		Condition condition = phoneRepository.findById((long) 1).get().getCondition();
		System.out.println("Haetaan id:llä 1 " + condition);
		// Testataan että haku toimii oikein.
		assertEquals(condition.getName(), "Excellent");
		
	}
	@Test
	public void insertNewPhone() {
		Phone phone = new Phone(null, "iPhone", "11", "128gb", 2019, 450, null);
		phoneRepository.save(phone);
		assertNotNull(phone.getId());
	}

}
