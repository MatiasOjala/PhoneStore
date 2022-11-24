package s22.PhoneStore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import s22.PhoneStore.web.PhoneStoreController;

@SpringBootTest
class PhoneStoreApplicationTests {

	@Autowired
	PhoneStoreController phoneStoreController;
	
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(phoneStoreController).isNotNull();
	}

}
