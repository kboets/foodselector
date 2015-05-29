package foodselector.web.base.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;

import foodselector.domain.Spices;
import foodselector.domain.Vegetables;
import foodselector.service.ISpicesService;
import foodselector.service.IVegetablesService;
import foodselector.web.base.validation.SpicesValidator;

@Controller
public class SpicesController {

	private static final String toSpicesOverview = "toSpicesOverview";
	private static final String toSpicesPageOverview = "toSpicesPageOverview";
	private final static String toSpicesPageOverviewRedirect = "redirect:/spicesPageOverview/1";
	private static final String toSpicesUpdate = "toSpicesUpdate";
	
	@Autowired	
	private ISpicesService spicesService;
	@Autowired
	private IVegetablesService vegetablesService;
	@Autowired
	private SpicesValidator validator;
	
	@RequestMapping(value = "/spicesOverview", method = RequestMethod.GET)
	public String getSpicesOverview(Model model) {		
		model.addAttribute("spicesList", getAllSpices());		
		return toSpicesOverview;
	}
	
	@RequestMapping(value = "/spicesPageOverview/{pageNumber}", method = RequestMethod.GET)
	public String getSpicesPerPage(Model model, @PathVariable Integer pageNumber) {
		Page<Spices> page = spicesService.getSpicesPage(pageNumber);
		
		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());
		
		model.addAttribute("spicesListPerPage", page);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		
		return toSpicesPageOverview;
	}
	
	@RequestMapping(value="/spicesUpdate/{id}")
	public String getUpdateSpices(Model model, @PathVariable("id") String id) {
		Spices spices = spicesService.getById(new Long(id));
		model.addAttribute("spices", spices);		
		Set<Vegetables> allVegetables = new HashSet<Vegetables>();		
		for(Vegetables vegetables : getAllVegetables()) {			
			if(!spices.getFavoriteVegetables().contains(vegetables)) {
				allVegetables.add(vegetables);
			} 
		}				
		model.addAttribute("vegetablesList", allVegetables);
		return toSpicesUpdate;
	}
	
	@RequestMapping(value="/spicesAdd")
	public String getAddSpices(Model model) {
		Spices spices = new Spices();
		model.addAttribute("spices", spices);						
		model.addAttribute("vegetablesList", getAllVegetables());
		return toSpicesUpdate;
	}	
	
	
	@RequestMapping(value = "/spicesUpdate/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
	public String updateSpices(HttpServletRequest request, @ModelAttribute("spices") Spices spices, 
			@PathVariable("id") String id, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		String action = request.getParameter("action");
		validator.validate(spices, result);
		if("back".equals(action)) {
			return toSpicesPageOverviewRedirect;
		} else if(StringUtils.isEmpty(action) && result.hasErrors()){	
			model.addAttribute("spices", spices);		
			Set<Vegetables> allVegetables = new HashSet<Vegetables>();		
			for(Vegetables vegetables : getAllVegetables()) {			
				if(!spices.getFavoriteVegetables().contains(vegetables)) {
					allVegetables.add(vegetables);
				} 
			}				
			model.addAttribute("vegetablesList", allVegetables);					
			request.setAttribute("exception", "exception.wrong.input");
			return toSpicesUpdate;
		} else {			
			spicesService.save(spices);		
			redirectAttributes.addFlashAttribute("success", "spicesUpdate");	
		}
		
		return toSpicesPageOverviewRedirect;
	}
	
	@RequestMapping(value = "/spicesAdd", method = {RequestMethod.POST, RequestMethod.PUT})
	public String addSpices(HttpServletRequest request, @ModelAttribute("spices") Spices spices, 
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		String action = request.getParameter("action");
		validator.validate(spices, result);
		if("back".equals(action)) {
			return toSpicesPageOverviewRedirect;
		} else if(StringUtils.isEmpty(action) && result.hasErrors()){	
			model.addAttribute("spices", spices);		
			model.addAttribute("vegetablesList", getAllVegetables());								
			request.setAttribute("exception", "exception.wrong.input");
			return toSpicesUpdate;
		} else {			
			spicesService.save(spices);		
			redirectAttributes.addFlashAttribute("success", "spicesAdd");	
		}
		
		return toSpicesPageOverviewRedirect;
	}
	
	private List<Spices> getAllSpices() {
		Iterable<Spices> iterable = spicesService.getAll();
		return Lists.newArrayList(iterable); 
	}
	
	private List<Vegetables> getAllVegetables() {
		Iterable<Vegetables> iterable = vegetablesService.getAll(); 
		return Lists.newArrayList(iterable);
	}
}

