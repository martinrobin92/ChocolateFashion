package com.shopping.Controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.exception.ProductNotFoundException;
import com.shopping.shoppingBackend.dao.CategoryDAO;
import com.shopping.shoppingBackend.dao.ProductDAO;
import com.shopping.shoppingBackend.dto.Category;
import com.shopping.shoppingBackend.dto.Product;

@Controller
public class PageController {
	
private static final Logger logger = LoggerFactory.getLogger(PageController.class);	
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
@RequestMapping(value= {"/","home"})
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("page");
		view.addObject("title", "Chocolate Home");
		
		logger.info("Inside index page - INFO");
		logger.debug("Inside index page - DEBUG");
		
		
		view.addObject("categories", categoryDAO.list());
		view.addObject("userClickHome", true);
		return view;
	}

/** Testing  **/
//@RequestMapping(value= "/save")
//public ModelAndView save() {
//	ModelAndView view = new ModelAndView("page");
//	view.addObject("title", "Chocolate Home");
//List<Category> 	cat = categoryDAO.list();
//	categoryDAO.addCategory(cat);
//	view.addObject("userClickHome", true);
//	return view;
//}

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
/**
 * Showing Single Product
 * */
@RequestMapping(value= "/show/{id}/products")
public ModelAndView showSingleProduct(@PathVariable int id)throws ProductNotFoundException {
	ModelAndView view = new ModelAndView("page");
	
	Product product = productDAO.getId(id);
	if(product == null)throw new ProductNotFoundException();
	//Setting View Count
	product.setViews(product.getViews() + 1);
	productDAO.updateProduct(product);
	
	view.addObject("title", product.getName());
	view.addObject("product", product);
	
	view.addObject("userClickShowProduct", true);

	return view;
	
	
}

}
