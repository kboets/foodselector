package foodselector.service;

import java.util.List;

import foodselector.domain.FishOrigin;
import foodselector.domain.enums.FishType;

public interface IFishOriginService extends IAbstractService<FishOrigin, Long> {

	List<FishOrigin> findByFishType(FishType fishType);
	
	FishOrigin findByName(String name);
}
