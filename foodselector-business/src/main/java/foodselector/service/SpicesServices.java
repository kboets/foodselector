package foodselector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import foodselector.domain.Spices;
import foodselector.repository.SpicesRepository;

@Service
public class SpicesServices extends AbstractService<Spices, Long> implements
		ISpicesService {

	private static final int PAGE_SIZE = 3;
	private SpicesRepository spicesRepository;

	@Autowired
	public void setSpicesRepository(SpicesRepository spicesRepository) {
		this.spicesRepository = spicesRepository;
		super.setRepository(spicesRepository);
	}

	@Override
	public Page<Spices> getSpicesPage(Integer pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber-1, PAGE_SIZE, Sort.Direction.ASC,"name");
		return spicesRepository.findAll(pageRequest);
	}
	
	

}
