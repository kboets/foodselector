package foodselector.web.base.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
		Pasta pasta = pastaService.getAll().get(0);
		if(pasta != null) {
			dishAdditives.add(pasta);
		}
		//potatoes
		dishAdditives.addAll(potatoService.getAll());  
		return dishAdditives;		
	}
	
	
	public List<DishAdditive> selectAdditive(DishAdditive  selectedAdditive) {
		List<DishAdditive> result = new ArrayList<DishAdditive>();		
		if(selectedAdditive instanceof Pasta) {
			result.addAll(pastaService.getAll());			
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
	
	
}
