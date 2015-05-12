package foodselector.web.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import foodselector.domain.Vegetables;
import foodselector.domain.VegetablesFamily;
import foodselector.domain.enums.Availability;
import foodselector.service.IVegetablesFamilyService;
import foodselector.service.IVegetablesService;
import foodselector.web.base.validation.VegetablesFamilyValidator;


@Controller
public class VegetablesController {

	private static final String toVegetablesFamilyOverview = "toVegetablesFamilyOverview";
	private final static String toVegetablesFamilyOverviewRedirect = "redirect:/vegetablesFamilyOverview";
	private final static String toVegetablesAddRedirect = "redirect:/vegetablesAdd";
	private static final String toVegetablesFamilyAdd = "toVegetablesFamilyAdd";
	private static final String toVegetablesAdd = "toVegetablesAdd";
	
	@Autowired
	private IVegetablesService vegetablesService;
	@Autowired
	private IVegetablesFamilyService vegetablesFamilyService;
	@Autowired
	private VegetablesFamilyValidator vegetablesFamilyValidator;
	
	@RequestMapping(value = "/vegetablesFamilyOverview", method = RequestMethod.GET)
	public String getVegetablesFamilyOverview(Model model) {		
		model.addAttribute("vegetablesFamilyOverview", getAllVegetablesFamilies());		
		return toVegetablesFamilyOverview;
	}
	@RequestMapping(value = "/vegetablesFamilyAdd", method = RequestMethod.GET)
	public String getVegetablesFamily(Model model) {
		VegetablesFamily vegetablesFamily = new VegetablesFamily();
		model.addAttribute("vegetablesFamily", vegetablesFamily);
		return toVegetablesFamilyAdd;
	}
	@RequestMapping(value = "/vegetablesFamilyUpdate/{id}", method = RequestMethod.GET)
	public String updateVegetablesFamily(Model model, @PathVariable("id") String id) {
		VegetablesFamily vegetablesFamily = vegetablesFamilyService.getById(new Long(id));
		model.addAttribute("vegetablesFamily", vegetablesFamily);
		return toVegetablesFamilyAdd;
	}
	
	@RequestMapping(value = "/vegetablesFamilyAdd", method = {RequestMethod.POST, RequestMethod.PUT})
	public String saveVegetablesFamily(HttpServletRequest request, @Valid @ModelAttribute("vegetablesFamily") VegetablesFamily vegetablesFamily, 
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {		
		String action = request.getParameter("action");				
		if("back".equals(action)){
			return toVegetablesFamilyOverviewRedirect;
		} else if(StringUtils.isEmpty(action) && result.hasErrors()){			
			request.setAttribute("exception", "exception.wrong.input");
			return "toVegetablesFamilyAdd";
		} else {
			vegetablesFamilyService.save(vegetablesFamily);
			redirectAttributes.addFlashAttribute("success", "vegetablesFamily");	
		}
		return toVegetablesFamilyOverviewRedirect;	
		
	}
	@RequestMapping(value = "/vegetablesFamilyUpdate/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
	public String updateVegetablesFamily(HttpServletRequest request, @Valid @ModelAttribute("vegetablesFamily") VegetablesFamily vegetablesFamily, 
			@PathVariable("id") String id, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		String action = request.getParameter("action");
		if("back".equals(action)){
			return toVegetablesFamilyOverviewRedirect;
		} else if(StringUtils.isEmpty(action) && result.hasErrors()){			
			request.setAttribute("exception", "exception.wrong.input");
			return "toVegetablesFamilyAdd";
		} else {
			vegetablesFamily.setId(new Long(id));
			vegetablesFamilyService.save(vegetablesFamily);
			redirectAttributes.addFlashAttribute("success", "vegetablesFamilyUpdated");	
		}
		
		return toVegetablesFamilyOverviewRedirect;	
	}
	
	@RequestMapping(value = "/vegetablesAdd", method = RequestMethod.GET)
	public String getAddVegetables(Model model) {
		Vegetables vegetables = new Vegetables();
		model.addAttribute("vegetables", vegetables);		
		model.addAttribute("availabilities", Availability.values());
		model.addAttribute("vegetablesFamilies", getAllVegetablesFamilies());		
		return toVegetablesAdd;
	}
	
	@RequestMapping(value = "/vegetablesUpdate/{id}", method = RequestMethod.GET)
	public String getUpdateVegetables(Model model, @PathVariable("id") String id) {
		Vegetables vegetables = vegetablesService.getById(new Long(id));
		model.addAttribute("vegetables", vegetables);		
		model.addAttribute("availabilities", Availability.values());
		model.addAttribute("vegetablesFamilies", getAllVegetablesFamilies());		
		return toVegetablesAdd;
	}
	
		
	@RequestMapping(value = "/vegetablesAdd", method = {RequestMethod.POST, RequestMethod.PUT})
	public String saveVegetables(HttpServletRequest request, @Valid @ModelAttribute("vegetables") Vegetables vegetables, 
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		String action = request.getParameter("action");
		if("back".equals(action)) {
			return toVegetablesFamilyOverviewRedirect;
		} else if(StringUtils.isEmpty(action) && result.hasErrors()){	
			request.setAttribute("exception", "exception.wrong.input");
			return toVegetablesAddRedirect;
		} else {
			vegetablesService.save(vegetables);		
			redirectAttributes.addFlashAttribute("success", "vegetables");	
		}
		
		return toVegetablesFamilyOverviewRedirect;
	}

	@RequestMapping(value = "/vegetablesUpdate/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
	public String updateVegetables(HttpServletRequest request, @Valid @ModelAttribute("vegetables") Vegetables vegetables, 
			@PathVariable("id") String id, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		String action = request.getParameter("action");
		if("back".equals(action)) {
			return toVegetablesFamilyOverviewRedirect;
		} else if(StringUtils.isEmpty(action) && result.hasErrors()){	
			request.setAttribute("exception", "exception.wrong.input");
			return "vegetablesAdd";
		} else {
			vegetables.setId(new Long(id));
			vegetablesService.save(vegetables);		
			redirectAttributes.addFlashAttribute("success", "vegetablesUpdate");	
		}
		
		return toVegetablesFamilyOverviewRedirect;
	}

	
	private List<VegetablesFamily> getAllVegetablesFamilies() {
		Iterable<VegetablesFamily> iterable = vegetablesFamilyService.getAll(); 
		return Lists.newArrayList(iterable);
	}
	
	
	
}
