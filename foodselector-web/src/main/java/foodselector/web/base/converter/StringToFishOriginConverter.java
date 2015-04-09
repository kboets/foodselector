package foodselector.web.base.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import foodselector.domain.FishOrigin;
import foodselector.service.IFishOriginService;

public class StringToFishOriginConverter implements Converter<String, FishOrigin> {

	@Autowired
	private IFishOriginService fishOriginService;
	
	@Override
	public FishOrigin convert(String name) {
		return fishOriginService.findByName(name);		
	}

	
	

}
