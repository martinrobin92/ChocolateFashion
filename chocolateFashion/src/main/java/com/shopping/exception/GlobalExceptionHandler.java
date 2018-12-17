package com.shopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView exceptionHandler() {
		ModelAndView view = new ModelAndView("error");
		view.addObject("errortitle", "The Page Is Not Constructed");
		
		view.addObject("errordescription", "The Page You Are Lokking For Is Not Available");
		
		view.addObject("title", "404 Error page");
		return view;
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView productExceptionHandler() {
		ModelAndView view = new ModelAndView("error");
		view.addObject("errortitle", "product not found");
		
		view.addObject("errordescription", "The Product You Are Looking For Is Not Available right now");
		
		view.addObject("title", "Product Unavailable");
		return view;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView ExceptionHandler(Exception ex) {
		ModelAndView view = new ModelAndView("error");
		view.addObject("errortitle", "Contact Your Adminstrator");
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		view.addObject("errordescription", sw.toString());
		
		view.addObject("title", "Error");
		return view;
	}
	
}
