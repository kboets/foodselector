package foodselector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodselector.domain.FishOrigin;
import foodselector.domain.enums.FishType;
import foodselector.repository.FishOriginRepository;

@Service
public class FishOriginService extends AbstractService<FishOrigin, Long> implements IFishOriginService {

	private FishOriginRepository fishOriginRepository;
	
	@Autowired
	public void setFishRepository(FishOriginRepository fishOriginRepository) {
		this.fishOriginRepository = fishOriginRepository;
		super.setRepository(fishOriginRepository);
	}

	@Override
	public List<FishOrigin> findByFishType(FishType fishType) {		
		return fishOriginRepository.findByFishType(fishType);
	}

	@Override
	public FishOrigin findByName(String name) {		
		return fishOriginRepository.findByName(name);
	}

}
