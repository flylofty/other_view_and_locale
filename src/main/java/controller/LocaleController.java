package controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class LocaleController {
	
	@GetMapping("/changeLanguage")
	public String changeLanguage(String language,
								 @RequestParam(required = false, defaultValue = "redirect:/") String redirectUri,
								 HttpServletRequest request,
								 HttpServletResponse response) 
	{
		Locale locale = new Locale(language);
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		localeResolver.setLocale(request, response, locale);
		return redirectUri;
	}
}
