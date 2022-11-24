package s22.PhoneStore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CoonditionRepository extends CrudRepository<Coondition, Long> {

	List<Coondition> findByName(String name);
}
