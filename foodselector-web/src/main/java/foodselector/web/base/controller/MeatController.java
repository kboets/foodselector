package foodselector.web.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import foodselector.domain.Meat;
import foodselector.domain.MeatOrigin;
import foodselector.service.IMeatOriginService;
import foodselector.service.IMeatService;
import foodselector.web.base.validation.MeatValidator;

@Controller
public class MeatController {

	private final static String toMeatOverview = "toMeatOverview";
	private final static String toMeatAdd = "toMeatAdd";
	private final static String toMeatOverviewRedirect = "redirect:/meatOverview";
	private final static String toMeatAddRedirect = "redirect:meatAdd";
	@Autowired
	private IMeatService meatService;
	@Autowired
	private IMeatOriginService meatOriginService;
	
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {		
		binder.setValidator(new MeatValidator());
	}
	
	
	@RequestMapping(value = "/meatOverview", method = RequestMethod.GET)
	public String getMeatOverview(Model model) {		
		model.addAttribute("meatOverview", meatOriginService.getAll());
		return toMeatOverview;
	}

	@RequestMapping(value = "/meatAdd", method = RequestMethod.GET)
	public String getAddMeat(HttpServletRequest request,
			HttpServletResponse response, Model model) {		
		model.addAttribute("meatOverview", meatOriginService.getAll());
		Meat meat = new Meat();
		model.addAttribute("meat", meat);
		return toMeatAdd;
	}
	
	@RequestMapping(value = "/meatUpdate/{id}", method = RequestMethod.GET)
	public String getUpdateMeat(HttpServletRequest request,
			HttpServletResponse response, Model model, @PathVariable("id") String id) {
		Meat meat = meatService.getById(new Long(id));
		model.addAttribute("meatOverview", meatOriginService.getAll());
		model.addAttribute("meat", meat);
		return toMeatAdd;
	}
	

	@RequestMapping(value = "/meatAdd", method = {RequestMethod.POST, RequestMethod.PUT})
	public String saveMeat(HttpServletRequest request, @Valid @ModelAttribute("meat") Meat meat,
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		String action = request.getParameter("action");
		if("back".equals(action)){
			return toMeatOverviewRedirect;
		} else if(StringUtils.isEmpty(action) && result.hasErrors()){	
			model.addAttribute("meatOverview", meatOriginService.getAll());
			request.setAttribute("exception", "exception.wrong.input");
			return toMeatAdd;
		} else {
			meatService.save(meat);
			redirectAttributes.addFlashAttribute("success", "meatAdded");	
		}		
		
		return toMeatOverviewRedirect;
	}
	
	@RequestMapping(value = "/meatUpdate/{id}", method = {RequestMethod.PUT})
	public String updateMeat(HttpServletRequest request, @Valid @ModelAttribute("meat") Meat meat,
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		String action = request.getParameter("action");
		if("back".equals(action)){
			return toMeatOverviewRedirect;
		} else if(StringUtils.isEmpty(action) && result.hasErrors()){	
			model.addAttribute("meatOverview", meatOriginService.getAll());
			request.setAttribute("exception", "exception.wrong.input");
			return toMeatAdd;
		} else {	
			meatService.save(meat);
			redirectAttributes.addFlashAttribute("success", "meatUpdated");	
		}		
		
		return toMeatOverviewRedirect;
	}
	
	 
	
//	public List<MeatOrigin> getAllMeatOrigins() {		
//		Iterable<MeatOrigin> iterable = meatOriginService.getAll();
//		return Lists.newArrayList(iterable);
//		
//	}


	

}
