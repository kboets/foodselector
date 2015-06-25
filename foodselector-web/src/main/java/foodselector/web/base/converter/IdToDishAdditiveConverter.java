package foodselector.web.base.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import foodselector.domain.DishAdditive;
import foodselector.service.IPastaService;
import foodselector.service.IPotatoService;

public class IdToDishAdditiveConverter implements Converter<String, DishAdditive> {

	@Autowired
	private IPotatoService potatoService;
	@Autowired
	private IPastaService pastaService;
	
	
	
	@Override
	public DishAdditive convert(String descriptionCode) {
		String [] codes = StringUtils.split(descriptionCode, ".");
		if(codes[0].equals("pasta")){
			return pastaService.findByDescriptionCode(descriptionCode);
		} else if(codes[0].equals("potato")) {
			return potatoService.findByDescriptionCode(descriptionCode);
		}
		return null;
	}
	
	
	
}
