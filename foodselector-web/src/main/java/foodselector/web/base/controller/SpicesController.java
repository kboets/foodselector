package foodselector.web.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Lists;

import foodselector.domain.Spices;
import foodselector.service.ISpicesService;

@Controller
public class SpicesController {

	private static final String toSpicesOverview = "toSpicesOverview";
	
	@Autowired	
	private ISpicesService spicesService;
	
	@RequestMapping(value = "/spicesOverview", method = RequestMethod.GET)
	public String getSpicesOverview(Model model) {		
		model.addAttribute("spicesList", getAllSpices());		
		return toSpicesOverview;
	}
	
	
	private List<Spices> getAllSpices() {
		Iterable<Spices> iterable = spicesService.getAll();
		return Lists.newArrayList(iterable); 
	}
}

