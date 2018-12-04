package com.shopping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
@RequestMapping(value= {"/","home"})
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("page");
		view.addObject("title", "Chocolate Home");
		view.addObject("userClickHome", true);
		return view;
	}
@RequestMapping(value= "/about")
public ModelAndView about() {
	ModelAndView view = new ModelAndView("page");
	view.addObject("title", "About Us");
	view.addObject("userClickAbout", true);
	return view;
}
@RequestMapping(value= "/contacts")
public ModelAndView contacts() {
	ModelAndView view = new ModelAndView("page");
	view.addObject("title", "Contact Us");
	view.addObject("userClickContacts", true);
	return view;
}
}
