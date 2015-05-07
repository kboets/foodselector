package foodselector.web.base.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import foodselector.domain.Vegetables;
import foodselector.service.IVegetablesService;

public class IdToVegetablesConverter implements Converter<String, Vegetables> {

	@Autowired
	private IVegetablesService vegetablesService;

	@Override
	public Vegetables convert(String vegetablesId) {		
		return vegetablesService.getById(new Long(vegetablesId));
	}
	
	
}
