package foodselector.web.base.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import foodselector.domain.DishAdditive;
import foodselector.service.IPastaService;

@Controller
public class DishController {

	@Autowired
	private IPastaService pastaService;
	
	public List<DishAdditive> createDishAdditives() {
		List<DishAdditive> dishAdditives = new ArrayList<DishAdditive>();
		
		return null;
		
	}
	
}
