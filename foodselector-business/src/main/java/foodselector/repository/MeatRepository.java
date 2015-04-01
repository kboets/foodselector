package foodselector.repository;

import org.springframework.data.repository.CrudRepository;

import foodselector.domain.Meat;

public interface MeatRepository extends CrudRepository<Meat, Long> {

	Meat findByName(String name);
	
	
}
