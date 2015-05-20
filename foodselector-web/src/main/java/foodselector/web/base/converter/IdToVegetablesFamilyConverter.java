package foodselector.web.base.converter;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import foodselector.domain.VegetablesFamily;
import foodselector.service.IVegetablesFamilyService;

public class IdToVegetablesFamilyConverter implements Converter<String, VegetablesFamily> {

	@Autowired
	private IVegetablesFamilyService vegetablesFamilyService;
	
	@Override
	public VegetablesFamily convert(String vegetablesFamilyId) {
		if(StringUtils.isEmpty(vegetablesFamilyId)) {
			return new VegetablesFamily();
		}
		return vegetablesFamilyService.getById(new Long(vegetablesFamilyId));		
	}

}
