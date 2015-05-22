package foodselector.web.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Lists;

import foodselector.domain.Spices;
import foodselector.service.ISpicesService;

@Controller
public class SpicesController {

	private static final String toSpicesOverview = "toSpicesOverview";
	private static final String toSpicesPageOverview = "toSpicesPageOverview";
	
	@Autowired	
	private ISpicesService spicesService;
	
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
	
	
	private List<Spices> getAllSpices() {
		Iterable<Spices> iterable = spicesService.getAll();
		return Lists.newArrayList(iterable); 
	}
}

