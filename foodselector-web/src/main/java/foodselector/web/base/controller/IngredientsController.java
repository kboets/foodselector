package foodselector.web.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IngredientsController {

	private static final String INGREDIENTS_OVERVIEW ="toIngredients";
	
	@RequestMapping(value="/ingredients", method=RequestMethod.GET)
	public String ingredientsOverview(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
	
		return INGREDIENTS_OVERVIEW;
	}
}
