package foodselector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodselector.domain.Potato;
import foodselector.repository.PotatoRepository;

@Service
public class PotatoService extends AbstractService<Potato, Long> implements
		IPotatoService {

	private PotatoRepository potatoRepository;

	@Autowired
	public void setPotatoRepository(PotatoRepository potatoRepository) {		
		this.potatoRepository = potatoRepository;
		super.setRepository(potatoRepository);
	}

}
