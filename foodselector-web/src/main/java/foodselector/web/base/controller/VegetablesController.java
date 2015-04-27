package foodselector.web.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Lists;

import foodselector.domain.VegetablesFamily;
import foodselector.service.IVegetablesFamilyService;
import foodselector.service.IVegetablesService;


@Controller
public class VegetablesController {

	private static final String toVegetablesFamilyOverview = "toVegetablesFamilyOverview";
	
	@Autowired
	private IVegetablesService vegetablesService;
	@Autowired
	private IVegetablesFamilyService vegetablesFamilyService;
	
	@RequestMapping(value = "/vegetablesFamilyOverview", method = RequestMethod.GET)
	public String getVegetablesFamilyOverview(Model model) {		
		model.addAttribute("vegetablesFamilyOverview", getAllVegetablesFamilies());		
		return toVegetablesFamilyOverview;
	}

	private List<VegetablesFamily> getAllVegetablesFamilies() {
		Iterable<VegetablesFamily> iterable = vegetablesFamilyService.getAll(); 
		return Lists.newArrayList(iterable);
	}
	
	
}
