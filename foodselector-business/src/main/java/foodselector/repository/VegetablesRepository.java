package foodselector.repository;

import org.springframework.data.repository.CrudRepository;

import foodselector.domain.Vegetables;


public interface VegetablesRepository extends CrudRepository<Vegetables, Long> {

	

}
