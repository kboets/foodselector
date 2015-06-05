package foodselector.web.base.util;

import java.util.Locale;

import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

public class RedirectNotExposingModelUrlBasedViewResolver extends
		UrlBasedViewResolver {

	@Override
	protected View createView(String viewName, Locale locale) throws Exception {
		View view = super.createView(viewName, locale);
		if (view instanceof RedirectView) {
			((RedirectView) view).setExposeModelAttributes(false);
		}
		return view;
	}
	
}
