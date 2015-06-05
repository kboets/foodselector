package foodselector.web.base.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import foodselector.domain.Dish;
import foodselector.domain.DishAdditive;
import foodselector.domain.Pasta;
import foodselector.service.IPastaService;
import foodselector.service.IPotatoService;

@Controller
public class DishController {

	@Autowired
	private IPastaService pastaService;
	@Autowired
	private IPotatoService potatoService;
	
	public Dish createDish() {		 
		return new Dish();
	}
	
	public List<DishAdditive> createDishAdditives() {
		List<DishAdditive> dishAdditives = new ArrayList<DishAdditive>();
		Pasta pasta = pastaService.getAll().get(0);
		if(pasta != null) {
			dishAdditives.add(pasta);
		}
		dishAdditives.addAll(potatoService.getAll());  
		return dishAdditives;		
	}
	
}
