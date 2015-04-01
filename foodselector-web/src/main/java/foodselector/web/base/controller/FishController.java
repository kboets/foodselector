package foodselector.web.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Lists;

import foodselector.domain.FishOrigin;
import foodselector.domain.enums.FishType;
import foodselector.service.IFishOriginService;
import foodselector.service.IFishService;

@Controller
public class FishController {

	private static final String toFishOriginOverview = "toFishOriginOverview";
	private static final String toFishOriginAdd = "toFishOriginAdd";
	private final static String toFishOriginOverviewRedirect = "redirect:/fishOriginOverview";
	@Autowired
	private IFishService fishService;
	@Autowired
	private IFishOriginService fishOriginService;
	
	@RequestMapping(value = "/fishOriginOverview", method = RequestMethod.GET)
	public String getFishOriginOverview(Model model) {
		model.addAttribute("fishOriginOverview", getAllFishOrigins());
		
		return toFishOriginOverview;
	}
	@RequestMapping(value = "/fishOriginAdd", method = RequestMethod.GET)
	public String addFishOrigin(Model model) {
		FishOrigin fishOrigin = new FishOrigin();
		model.addAttribute("fishOrigin", fishOrigin);
		model.addAttribute("fishTypes", FishType.values());
		return toFishOriginAdd; 
	}
	
	private List<FishOrigin> getAllFishOrigins() {
		Iterable<FishOrigin> result = fishOriginService.getAll();
		return Lists.newArrayList(result);
	}
	
}
