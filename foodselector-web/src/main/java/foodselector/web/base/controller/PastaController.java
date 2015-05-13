package foodselector.web.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Lists;

import foodselector.domain.Pasta;
import foodselector.service.IPastaService;

@Controller
public class PastaController {
	
	private static final String toPastaOverview = "toPastaOverview";
	
	@Autowired
	private IPastaService pastaService;
	
	@RequestMapping(value = "/pastaOverview", method = RequestMethod.GET)
	public String getPastaOverview(Model model) {		
		model.addAttribute("pastas", getAllPastas());		
		return toPastaOverview;
	}
	
	
	private List<Pasta> getAllPastas() {
		Iterable<Pasta> iterable =  pastaService.getAll();
		return Lists.newArrayList(iterable);
	}
}
