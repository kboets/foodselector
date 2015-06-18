package foodselector.web.base.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import foodselector.domain.DishAdditive;
import foodselector.service.IPastaService;

public class IdToDishAdditiveConverter implements Converter<String, DishAdditive> {

	
	
	@Override
	public DishAdditive convert(String descriptionCode) {
		
		return null;
	}

}
