package foodselector.web.base.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.message.MessageResolver;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

import foodselector.domain.Dish;

@Component
public class DishModelValidator {

	public void validateSelectVegetable(Dish dish, ValidationContext context) {
		MessageContext messages = context.getMessageContext();
		if(StringUtils.isBlank(dish.getName())) {
			 messages.addMessage(new MessageBuilder().error().source("name").code("no.name").build());
		}
		if(dish.getPickedAdditive() == null) {
			 messages.addMessage(new MessageBuilder().error().source("pickedAdditive").code("no.additive.selected").build());
		}
	}
}
