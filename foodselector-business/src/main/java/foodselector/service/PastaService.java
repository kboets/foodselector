package foodselector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodselector.domain.Pasta;
import foodselector.repository.PastaRepository;

@Service
public class PastaService extends AbstractService<Pasta, Long> implements
		IPastaService {

	private PastaRepository pastaRepository;	

	@Autowired
	public void setPastaRepository(PastaRepository pastaRepository) {
		this.pastaRepository = pastaRepository;
		super.setRepository(pastaRepository);
	}

	@Override
	public Pasta findByDescriptionCode(String descripionCode) {		
		return getAll().get(0);
	}
	
	
	
}
