package s22.PhoneStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s22.PhoneStore.domain.ApplicationUser;
import s22.PhoneStore.domain.ApplicationUserRepository;
import s22.PhoneStore.domain.Coondition;
import s22.PhoneStore.domain.CoonditionRepository;
import s22.PhoneStore.domain.Phone;
import s22.PhoneStore.domain.PhoneRepository;


// Pääohjelma

@SpringBootApplication
public class PhoneStoreApplication {
private static final Logger Log = LoggerFactory.getLogger(PhoneStoreApplication.class);
	
	@Autowired
	CoonditionRepository condRepository;
	
	@Autowired
	PhoneRepository phoneRepository;
	
	@Autowired
	ApplicationUserRepository auRepository;

	public static void main(String[] args) {
		SpringApplication.run(PhoneStoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner phonestore(PhoneRepository phoneRepository) {
		return (args) -> {
			
			// Määritetään käyttäjät.
			Log.info("luodaan kaksi käyttäjää sovellukselle");
			auRepository.save(new ApplicationUser("Matias", "Ojala", "USER", "user", 
					"$2a$10$qTuhvwviu0XCo5UWYECE5eHzFuXV6AfndNOPjF1JDIJOs7Mz7pDzG"));
			auRepository.save(new ApplicationUser("Saitam", "Alajo", "ADMIN", "admin", 
					"$2a$10$ng6O4VyeXpWG12/WkA7AI.d.AsINXpIgJLd3PG1k9VIeR0OQbsB6G"));
			
			// Määritetään hieman kunto tasoa.
			Log.info("save a few coonditons for phones");
			condRepository.save(new Coondition("Excellent"));
			condRepository.save(new Coondition("OK"));
			condRepository.save(new Coondition("Bad"));
			condRepository.save(new Coondition("Average"));
			condRepository.save(new Coondition("Above average"));
			condRepository.save(new Coondition("Below average"));
			
			// Määritetään hieman testi puhelinta.
			phoneRepository.save(new Phone(null, "iPhone", "13 Pro", "256gb", 2021, 1000, condRepository.findByName("Excellent").get(0)));
			phoneRepository.save(new Phone(null, "iPhone", "12 Pro", "128gb", 2020, 700, condRepository.findByName("OK").get(0)));
			phoneRepository.save(new Phone(null, "iPhone", "11", "64gb", 2019, 350, condRepository.findByName("Bad").get(0)));
			phoneRepository.save(new Phone(null, "Samsung", "Galaxy S10", "64gb", 2020, 600, condRepository.findByName("Average").get(0)));
			phoneRepository.save(new Phone(null, "Samsung", "Galaxy S10+", "64gb", 2020, 900, condRepository.findByName("Excellent").get(0)));
			phoneRepository.save(new Phone(null, "Samsung", "Galaxy S9", "64gb", 2017, 400, condRepository.findByName("Below average").get(0)));
			
			// Haetaan kaikki puhelimet.
			Log.info("fetch all phones");
			for (Phone phone : phoneRepository.findAll()) {
					Log.info(phone.toString());
			}
		};
	}

}
