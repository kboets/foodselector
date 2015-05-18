package foodselector.web.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;

import foodselector.domain.Pasta;
import foodselector.service.IPastaService;
import foodselector.web.base.validation.PastaValidator;

@Controller
public class PastaController {
	
	private static final String toPastaOverview = "toPastaOverview";
	private final static String toPastaOverviewRedirect = "redirect:/pastaOverview";
	private static final String toPastaAdd = "toPastaAdd";
	
	@Autowired
	private IPastaService pastaService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {		
		binder.setValidator(new PastaValidator());
	}
	
	@RequestMapping(value = "/pastaOverview", method = RequestMethod.GET)
	public String getPastaOverview(Model model) {		
		model.addAttribute("pastas", getAllPastas());		
		return toPastaOverview;
	}
	
	@RequestMapping(value = "/pastaAdd", method = RequestMethod.GET)
	public String getPastaAdd(Model model) {		
		Pasta pasta = new Pasta();
		model.addAttribute("pasta", pasta);		
		return toPastaAdd;
	}
	
	@RequestMapping(value = "/pastaUpdate/{id}", method = RequestMethod.GET)
	public String getPastaUpdate(Model model, @PathVariable("id") String id) {		
		Pasta pasta = pastaService.getById(new Long(id));
		model.addAttribute("pasta", pasta);		
		return toPastaAdd;
	}
	
	@RequestMapping(value = "/pastaAdd", method = {RequestMethod.POST, RequestMethod.PUT})
	public String savePasta(HttpServletRequest request, @Valid @ModelAttribute("pasta") Pasta pasta, 
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {		
		String action = request.getParameter("action");
		if("back".equals(action)){
			return toPastaOverviewRedirect;
		} else if(result != null && result.hasErrors()) {
			request.setAttribute("exception", "exception.wrong.input");
			return toPastaAdd;
		} else {
			pastaService.save(pasta);
			redirectAttributes.addFlashAttribute("success", "pasta");			
		}
		
		return toPastaOverviewRedirect;
	}
	
	@RequestMapping(value = "/pastaUpdate/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
	public String updatePasta(HttpServletRequest request, @Valid @ModelAttribute("pasta") Pasta pasta,
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {		
		String action = request.getParameter("action");
		if("back".equals(action)){
			return toPastaOverviewRedirect;
		} else if(result != null && result.hasErrors()) {
			request.setAttribute("exception", "exception.wrong.input");
			return toPastaAdd;
		} else {			
			pastaService.save(pasta);
			redirectAttributes.addFlashAttribute("success", "pastaUpdate");			
		}
		
		return toPastaOverviewRedirect;
	}
	private List<Pasta> getAllPastas() {
		Iterable<Pasta> iterable =  pastaService.getAll();
		return Lists.newArrayList(iterable);
	}
}
