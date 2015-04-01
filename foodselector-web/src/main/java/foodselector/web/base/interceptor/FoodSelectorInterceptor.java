package foodselector.web.base.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class FoodSelectorInterceptor extends HandlerInterceptorAdapter {

	private final String foodSelectorUrl;
	public static final String FOODSELECTOR_ADDRESS_KEY = "foodselector"; 
	
	public FoodSelectorInterceptor(String foodSelectorUrl) {
		this.foodSelectorUrl = foodSelectorUrl;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView != null) {
			modelAndView.addObject(FOODSELECTOR_ADDRESS_KEY, foodSelectorUrl);	
		} else {
			request.setAttribute(FOODSELECTOR_ADDRESS_KEY, foodSelectorUrl);
		}
	}
}
