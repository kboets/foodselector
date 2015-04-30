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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;

import foodselector.domain.FishOrigin;
import foodselector.domain.VegetablesFamily;
import foodselector.domain.enums.FishType;
import foodselector.service.IVegetablesFamilyService;
import foodselector.service.IVegetablesService;
import foodselector.web.base.validation.VegetablesFamilyValidator;


@Controller
public class VegetablesController {

	private static final String toVegetablesFamilyOverview = "toVegetablesFamilyOverview";
	private final static String toVegetablesFamilyOverviewRedirect = "redirect:/vegetablesFamilyOverview";
	private static final String toVegetablesFamilyAdd = "toVegetablesFamilyAdd";
	
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
	public String addVegetablesFamily(Model model) {
		VegetablesFamily vegetablesFamily = new VegetablesFamily();
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

	private List<VegetablesFamily> getAllVegetablesFamilies() {
		Iterable<VegetablesFamily> iterable = vegetablesFamilyService.getAll(); 
		return Lists.newArrayList(iterable);
	}
	
	
}
