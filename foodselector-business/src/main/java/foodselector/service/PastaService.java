package foodselector.service;

import org.springframework.beans.factory.annotation.Autowired;

import foodselector.domain.Pasta;
import foodselector.repository.PastaRepository;

public class PastaService extends AbstractService<Pasta, Long> implements
		IPastaService {

	private PastaRepository pastaRepository;	

	@Autowired
	public void setPastaRepository(PastaRepository pastaRepository) {
		this.pastaRepository = pastaRepository;
		super.setRepository(pastaRepository);
	}
	

}
