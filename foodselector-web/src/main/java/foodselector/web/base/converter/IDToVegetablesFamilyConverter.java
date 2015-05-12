package foodselector.web.base.converter;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import foodselector.domain.VegetablesFamily;
import foodselector.service.IVegetablesFamilyService;

public class IDToVegetablesFamilyConverter implements Converter<String, VegetablesFamily> {

	@Autowired
	private IVegetablesFamilyService vegetablesFamilyService;
	
	@Override
	public VegetablesFamily convert(String vegetablesFamilyId) {
		return vegetablesFamilyService.getById(new Long(vegetablesFamilyId));		
	}

}
