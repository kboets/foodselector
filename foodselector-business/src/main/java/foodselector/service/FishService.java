package foodselector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodselector.domain.Fish;
import foodselector.domain.FishOrigin;
import foodselector.repository.FishRepository;

@Service
public class FishService extends AbstractService<Fish, Long> implements IFishService {

	private FishRepository fishRepository;
	
	@Autowired
	public void setFishRepository(FishRepository fishRepository) {
		this.fishRepository = fishRepository;
		super.setRepository(fishRepository);
	}

	@Override
	public List<Fish> findByFishOrigin(FishOrigin fishOrigin) {
		return fishRepository.findByFishOrigin(fishOrigin);
	}

	@Override
	public Fish findByName(String name) {		
		return fishRepository.findByName(name);
	}

}
