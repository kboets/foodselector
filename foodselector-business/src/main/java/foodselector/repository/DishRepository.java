package foodselector.repository;

import org.springframework.data.repository.CrudRepository;

import foodselector.domain.Dish;

public interface DishRepository extends CrudRepository<Dish, Long> {

	
}
