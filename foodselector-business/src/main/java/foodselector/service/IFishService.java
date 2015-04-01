package foodselector.service;

import java.util.List;

import foodselector.domain.Fish;
import foodselector.domain.FishOrigin;

public interface IFishService extends IAbstractService<Fish, Long> {

	List<Fish> findByFishOrigin(FishOrigin fishOrigin);
	
	Fish findByName(String name);
}
