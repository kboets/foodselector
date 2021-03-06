package foodselector.web.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;

import foodselector.domain.Fish;
import foodselector.domain.FishOrigin;
import foodselector.domain.enums.FishType;
import foodselector.service.IFishOriginService;
import foodselector.service.IFishService;
import foodselector.web.base.validation.FishOriginValidator;
import foodselector.web.base.validation.FishValidator;

@Controller
public class FishController {

	private static final String toFishOriginOverview = "toFishOriginOverview";
	private static final String toFishOriginAdd = "toFishOriginAdd";
	private final static String toFishOriginOverviewRedirect = "redirect:/fishOriginOverview";
	private final static String toIngredientsRedirect= "redirect:/ingredients";
	private final static String toFishAdd = "toFishAdd";
	
	@Autowired
	private IFishService fishService;
	@Autowired
	private IFishOriginService fishOriginService;
	@Autowired
	private FishOriginValidator fishOriginValidator;
	@Autowired
	private FishValidator fishValidator;

	
	@InitBinder("fishOrigin")
	public void initFishOriginBinder(WebDataBinder binder) {	
		binder.setValidator(new FishOriginValidator());
		
	}
	@InitBinder("fish")
	public void initFishBinder(WebDataBinder binder) {
		binder.setValidator(new FishValidator());
	}
	
	@RequestMapping(value = "/fishOriginOverview", method = RequestMethod.GET)
	public String getFishOriginOverview(Model model) {
		model.addAttribute("fishOriginOverview", fishOriginService.getAll());
		
		return toFishOriginOverview;
	}
	@RequestMapping(value = "/fishOriginAdd", method = RequestMethod.GET)
	public String addFishOrigin(Model model) {
		FishOrigin fishOrigin = new FishOrigin();
		model.addAttribute("fishOrigin", fishOrigin);
		model.addAttribute("fishTypes", FishType.values());
		return toFishOriginAdd; 
	}
	
	@RequestMapping(value = "/fishOriginUpdate/{id}", method = RequestMethod.GET)
	public String updateFishOrigin(Model model, @PathVariable("id") String id) {
		FishOrigin fishOrigin = fishOriginService.getById(new Long(id));
		model.addAttribute("fishOrigin", fishOrigin);
		model.addAttribute("fishTypes", FishType.values());
		return toFishOriginAdd; 
	}
	
	@RequestMapping(value = "/fishOriginAdd", method = {RequestMethod.POST, RequestMethod.PUT})
	public String saveFishOrigin(HttpServletRequest request, @Valid @ModelAttribute("fishOrigin") FishOrigin fishOrigin, 
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {		
		String action = request.getParameter("action");		
		if("back".equals(action)){
			return toFishOriginOverviewRedirect;
		} else if(StringUtils.isEmpty(action) && result.hasErrors()){
			model.addAttribute("fishTypes", FishType.values());
			request.setAttribute("exception", "exception.wrong.input");
			return toFishOriginAdd;
		} else {
			fishOriginService.save(fishOrigin);
			redirectAttributes.addFlashAttribute("success", "fishOriginAdded");	
		}
		return toFishOriginOverviewRedirect;	
		
	}	
	
	
	@RequestMapping(value = "/fishOriginUpdate/{id}", method = RequestMethod.PUT) 
	public String updateFishOrigin(HttpServletRequest request, @Valid @ModelAttribute("fishOrigin") FishOrigin fishOrigin, 
				BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		String action = request.getParameter("action");
		if("back".equals(action)){
			return toFishOriginOverviewRedirect;
		} else if(StringUtils.isEmpty(action) && result.hasErrors()) {	
			model.addAttribute("fishTypes", FishType.values());
			request.setAttribute("exception", "exception.wrong.input");
			return toFishOriginAdd;
		} else {
			fishOriginService.save(fishOrigin);
			redirectAttributes.addFlashAttribute("success", "fishOriginAdded");	
		}
		return toFishOriginOverviewRedirect;	
	}
	
	@RequestMapping(value = "/fishAdd", method = RequestMethod.GET)
	public String addFish(Model model) {
		Fish fish = new Fish();
		model.addAttribute("fish", fish);
		model.addAttribute("fishOrigins", fishOriginService.getAll());
		return toFishAdd; 
	}
	
	@RequestMapping(value = "/fishUpdate/{id}", method = RequestMethod.GET)
	public String updateFish(Model model, @PathVariable("id") String id) {
		Fish fish = fishService.getById(new Long(id));		
		model.addAttribute("fish", fish);
		model.addAttribute("fishOrigins", fishOriginService.getAll());
		return toFishAdd; 
	}
	
	@RequestMapping(value = "/fishAdd", method = {RequestMethod.POST, RequestMethod.PUT})
	public String saveFish(HttpServletRequest request, @Valid @ModelAttribute("fish") Fish fish, 
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {		
		String action = request.getParameter("action");	
		if("back".equals(action)){
			return toFishOriginOverviewRedirect;
		} else if(StringUtils.isEmpty(action) && result.hasErrors()){			
			model.addAttribute("fishOrigins", fishOriginService.getAll());			
			request.setAttribute("exception", "exception.wrong.input");
			return toFishAdd;
		} else {
			fishService.save(fish);
			redirectAttributes.addFlashAttribute("success", "fishAdded");	
		}
		return toFishOriginOverviewRedirect;		
	}
	
	@RequestMapping(value = "/fishUpdate/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
	public String updateFish(HttpServletRequest request, @Valid @ModelAttribute("fish") Fish fish, 
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {		
		String action = request.getParameter("action");		
		if("back".equals(action)){
			return toFishOriginOverviewRedirect;
		} else if(StringUtils.isEmpty(action) && result.hasErrors()){			
			model.addAttribute("fishOrigins", fishOriginService.getAll());			
			request.setAttribute("exception", "exception.wrong.input");
			return toFishAdd;
		} else {
			fishService.save(fish);
			redirectAttributes.addFlashAttribute("success", "fishUpdated");	
		}
		return toFishOriginOverviewRedirect;	
		
	}	
	
}
