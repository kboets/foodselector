package foodselector.web.base.converter;

import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.google.common.collect.ImmutableMap;

import foodselector.domain.DishAdditive;

public class IdToDishAdditiveConverter implements Converter<String, DishAdditive> {

	
	
	@Override
	public DishAdditive convert(String descriptionCode) {
		String [] codes = StringUtils.split(descriptionCode, ".");
		if(codes[0].equals("pasta")){
			
		} else if(codes[0].equals("potato")) {
			
		}
		return null;
	}
	
	
	
}
