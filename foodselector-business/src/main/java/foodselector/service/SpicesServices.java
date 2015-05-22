package foodselector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodselector.domain.Spices;
import foodselector.repository.SpicesRepository;

@Service
public class SpicesServices extends AbstractService<Spices, Long> implements
		ISpicesService {

	
	private SpicesRepository spicesRepository;

	@Autowired
	public void setSpicesRepository(SpicesRepository spicesRepository) {
		this.spicesRepository = spicesRepository;
		super.setRepository(spicesRepository);
	}
	
	

}
