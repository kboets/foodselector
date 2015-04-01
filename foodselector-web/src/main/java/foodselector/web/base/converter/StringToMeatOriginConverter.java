package foodselector.web.base.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import foodselector.domain.MeatOrigin;
import foodselector.service.IMeatOriginService;

public class StringToMeatOriginConverter implements Converter<String, MeatOrigin> {

	@Autowired
	private IMeatOriginService meatOriginService;
	
	@Override
	public MeatOrigin convert(String meatOriginName) {		
		return meatOriginService.getMeatOriginByName(meatOriginName);
		//return meatOriginService.getById(new Long(meatOriginId));
	}

}
