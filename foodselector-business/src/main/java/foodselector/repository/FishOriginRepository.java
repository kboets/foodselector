package foodselector.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import foodselector.domain.FishOrigin;
import foodselector.domain.enums.FishType;

public interface FishOriginRepository extends CrudRepository<FishOrigin, Long> {

	List<FishOrigin> findByFishType(FishType fishType);
	
	FishOrigin findByName(String name);
}
