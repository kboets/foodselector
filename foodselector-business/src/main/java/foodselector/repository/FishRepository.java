package foodselector.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import foodselector.domain.Fish;
import foodselector.domain.FishOrigin;

public interface FishRepository extends CrudRepository<Fish, Long> {
	
	List<Fish> findByFishOrigin(FishOrigin fishOrigin);
	
	Fish findByName(String name);

}
