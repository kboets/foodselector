package foodselector.web.base.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import foodselector.domain.FishOrigin;
import foodselector.service.IFishOriginService;

public class IDToFishOriginConverter implements Converter<Long, FishOrigin> {

	@Autowired
	private IFishOriginService fishOriginService;
	
	@Override
	public FishOrigin convert(Long fishOriginId) {
		//FishOrigin origin = fishOriginService.findByName(fishOriginName);
		FishOrigin origin = fishOriginService.getById(fishOriginId);
		return 	origin;
	}

	
	

}
