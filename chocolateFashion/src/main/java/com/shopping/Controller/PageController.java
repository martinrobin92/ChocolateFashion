package com.shopping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
@RequestMapping(value= {"/","home"})
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("page");
		view.addObject("greet", "Hello welcome to jsp");
		return view;
	}
	
}
