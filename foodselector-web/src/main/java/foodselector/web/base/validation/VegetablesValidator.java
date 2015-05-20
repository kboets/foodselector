package foodselector.web.base.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import foodselector.domain.Vegetables;

public class VegetablesValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (Vegetables.class).isAssignableFrom(clazz) ;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "no.name");
		ValidationUtils.rejectIfEmpty(errors, "availability", "vegetables.no.availabiltiy");
		ValidationUtils.rejectIfEmpty(errors, "vegetablesFamily", "vegetables.no.vegetablesFamily");
	}

}
