package foodselector.web.base.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import foodselector.domain.Pasta;
import foodselector.service.IPastaService;

public class IdToPastaConverter implements Converter<String, Pasta> {

	@Autowired
	private IPastaService pastaService;
	
	@Override
	public Pasta convert(String id) {
		Pasta pasta = pastaService.getById(new Long(id));
		return pasta;
	}

}
