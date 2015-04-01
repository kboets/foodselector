package foodselector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import foodselector.domain.Meat;
import foodselector.repository.MeatRepository;

@Service
public class MeatService extends AbstractService<Meat, Long> implements IMeatService {

	
	private MeatRepository meatRepository;

	@Autowired
	public void setMeatRepository(MeatRepository meatRepository) {
		this.meatRepository = meatRepository;
		super.setRepository(meatRepository);
	}

	@Override
	@Transactional(readOnly=true)
	public Meat findByName(String name) {		
		return meatRepository.findByName(name);
	}

	
}
