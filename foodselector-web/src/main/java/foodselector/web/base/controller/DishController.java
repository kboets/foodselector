package foodselector.web.base.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import foodselector.domain.Dish;
import foodselector.domain.DishAdditive;
import foodselector.domain.Pasta;
import foodselector.domain.Vegetables;
import foodselector.service.IDishService;
import foodselector.service.IPastaService;
import foodselector.service.IPotatoService;
import foodselector.service.IVegetablesService;

@Controller
public class DishController {

	@Autowired
	private IPastaService pastaService;
	@Autowired
	private IPotatoService potatoService;
	@Autowired
	private IDishService dishService;
	@Autowired
	private IVegetablesService vegetablesService;
	
	public Dish createDish() {		 
		return new Dish();
	}
	
	public List<DishAdditive> createDishAdditives() {		
		List<DishAdditive> dishAdditives = new ArrayList<DishAdditive>();
		//pasta
		Pasta pasta = pastaService.getAll().get(0);
		if(pasta != null) {
			dishAdditives.add(pasta);
		}
		System.out.println("D:\schijf");		

		//potatoes
		dishAdditives.addAll(potatoService.getAll());  
		return dishAdditives;		
	}	
	
	
	public List<DishAdditive> determineTypeOfAdditives(DishAdditive chosenAdditive) {
		List<DishAdditive> result = new ArrayList<DishAdditive>();		
		if(chosenAdditive instanceof Pasta) {
			result.addAll(pastaService.getAll());			
		} else {
			result.add(chosenAdditive);			
		}
		
		return result;
	}

	public List<Vegetables> getAllVegetables() {
		return vegetablesService.getAll();		
	}
	
	
	public Dish saveDish(Dish dish) {
		Dish saveOrUpdated = dishService.save(dish); 
		return saveOrUpdated;
	}
	
	public void cancelDish(Dish dish) {
		if(dish.getId() != null) {
			dishService.delete(dish);
		}
	}
	
	public void resetDishAdditive(Dish dish) {
		dish.setAdditiveToChoose(null);
		dish.setPasta(null);
		dish.setPotato(null);
	}
	
	public Event validateDetermineAdditiveType(Dish dish, MessageContext messageContext) {
		boolean hasError = false;
		if(StringUtils.isBlank(dish.getName())) {
			MessageBuilder errorMessageBuilder = new MessageBuilder().error();
			errorMessageBuilder.source("name").code("no.name");
			messageContext.addMessage(errorMessageBuilder.build());
			dish.setAdditiveToChoose(null);
			hasError=true;
		} 
		if(dish.getAdditiveToChoose() == null) {
			MessageBuilder errorMessageBuilder = new MessageBuilder().error();
			errorMessageBuilder.source("additiveToChoose").code("no.additive.selected");
			messageContext.addMessage(errorMessageBuilder.build());
			dish.setAdditiveToChoose(null);
			hasError=true;			
		}
		if(hasError) {
			return new EventFactorySupport().error(this);	
		} else {
			return new EventFactorySupport().success(this);	
		}			
	}
	
	
	
	
	
	
}
