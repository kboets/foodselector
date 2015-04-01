package foodselector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodselector.domain.MeatOrigin;
import foodselector.repository.MeatOriginRepository;

@Service
public class MeatOriginService extends AbstractService<MeatOrigin, Long> implements IMeatOriginService{

	private MeatOriginRepository meatOriginRepository;

	@Autowired
	public void setMeatRepository(MeatOriginRepository meatRepository) {
		this.meatOriginRepository = meatRepository;
		super.setRepository(meatOriginRepository);
	}

	@Override
	public MeatOrigin getMeatOriginByName(String name) {		
		return meatOriginRepository.findByName(name);
	}
	
	
}
