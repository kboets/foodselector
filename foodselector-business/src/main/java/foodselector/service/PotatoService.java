package foodselector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodselector.domain.Potato;
import foodselector.domain.enums.PotatoType;
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

	@Override
	public Potato findByDescriptionCode(String descriptionCode) {
		PotatoType type = PotatoType.findByCode(descriptionCode);
		if(type != null) {
			return potatoRepository.findByPotatoType(type);
		}
		return null;
	}

}
