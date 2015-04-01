package foodselector.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import foodselector.domain.MeatOrigin;
import foodselector.domain.enums.MeatType;

public interface MeatOriginRepository extends CrudRepository<MeatOrigin, Long> {

	
	List<MeatOrigin> findByMeatType(MeatType meatType);
	
	MeatOrigin findByName(String name);

}
