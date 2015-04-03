package foodselector.web.base.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import foodselector.domain.Fish;
@Component
public class FishValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (Fish.class).isAssignableFrom(clazz) ;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "no.name");
		ValidationUtils.rejectIfEmpty(errors, "fishOrigin", "no.fishOrigin");
	}

}
