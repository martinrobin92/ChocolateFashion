package com.shopping.shoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.shoppingBackend.dao.ProductDAO;
import com.shopping.shoppingBackend.dto.Product;

public class ProductTest {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shopping.shoppingBackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	/*@Test
	public void testCRUD() {
		product = new Product();
		
		product.setName("samsung s3");
		product.setDescription("Classic Set");
		product.setUnitPrice(25000);
		product.setQuantity(5);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("successfully added",true,productDAO.addProduct(product));
		
product = new Product();
		
		product.setName("motrola");
		product.setDescription("old is gold");
		product.setUnitPrice(14000);
		product.setQuantity(4);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(2);
		
		assertEquals("successfully added",true,productDAO.addProduct(product));

   product = new Product();
		
		product.setName("nokia");
		product.setDescription("antique piece");
		product.setUnitPrice(250000);
		product.setQuantity(2);
		product.setActive(true);
		product.setCategoryId(1);
		product.setSupplierId(1);
		
		assertEquals("successfully added",true,productDAO.addProduct(product));
		//Getting by id and Updating it.
		
		product = productDAO.getId(3);
		product.setName("Iphone");
		
		assertEquals("fetched by id",true,productDAO.updateProduct(product));
		
		//Making a product inactive
		assertEquals("inactive", true,productDAO.deleteProduct(product));
		
		//List of Products
		assertEquals("Fetched Lists",5,productDAO.getlist().size());
		
	}
*/
	
	@Test
	public void test() {
		
	}
}
