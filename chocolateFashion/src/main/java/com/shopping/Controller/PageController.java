package com.shopping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.shoppingBackend.dao.CategoryDAO;
import com.shopping.shoppingBackend.dto.Category;

@Controller
public class PageController {
	@Autowired
	private CategoryDAO categoryDAO;
	
@RequestMapping(value= {"/","home"})
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("page");
		view.addObject("title", "Chocolate Home");
		view.addObject("categories", categoryDAO.list());
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

@RequestMapping(value= "/show/all/products")
public ModelAndView showAllProducts() {
	ModelAndView view = new ModelAndView("page");
	view.addObject("title", "All Products");
	view.addObject("categories", categoryDAO.list());
	view.addObject("userClickAllProducts", true);
	return view;
}

@RequestMapping(value= "/show/all/{id}/products")
public ModelAndView showcategoryProducts(@PathVariable("id") int id , Category category) {
	
	ModelAndView view = new ModelAndView("page");
	System.out.println("inside path id");
	category = categoryDAO.getId(id);
	
	view.addObject("title", category.getName());
	//passing all products
	view.addObject("categories", categoryDAO.list());
	//passing single category
	view.addObject("category1", category);
	
	view.addObject("userClickCategoryProducts", true);
	return view;
}



}
