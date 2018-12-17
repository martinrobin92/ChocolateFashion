package com.shopping.shoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.shoppingBackend.dao.CategoryDAO;
import com.shopping.shoppingBackend.dto.Category;

public class CategoryTest {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shopping.shoppingBackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	// Test For Adding Category //
	/*
	 * @Test public void addCategory() { category = new Category();
	 * 
	 * category.setName("jack"); category.setDescription("notorious");
	 * category.setImageURL("7.jpg");
	 * 
	 * assertEquals("success",true, categoryDAO.addCategory(category)); }
	 */

	// TEST CASE FOR FETCHING SINGLE CATEGORY
	/*
	 * @Test public void getCategory() {
	 * 
	 * category = categoryDAO.getId(2);
	 * 
	 * assertEquals("successfully fetched single category from table","martin",
	 * category.getName()); }
	 */

	// TEST CASE FOR UPDATING SINGLE CATEGORY
	/*
	 * @Test public void updateCategory() {
	 * 
	 * category = categoryDAO.getId(2);
	 * 
	 * category.setName("Robin");
	 * assertEquals("successfully updated single category from table",true,
	 * categoryDAO.updateCategory(category)); }
	 */

	// TEST CASE FOR DELETING SINGLE CATEGORY BY MAKING ITS ACTIVE VALUE AS FALSE
	/*
	 * @Test public void deleteCategory() {
	 * 
	 * category = categoryDAO.getId(2);
	 * 
	 * 
	 * assertEquals("successfully DELETED single category from table",true,
	 * categoryDAO.deleteCategory(category)); }
	 */

	// TEST CASE FOR FETCHING LIST OF CATEGORY BY MAKING ITS ACTIVE VALUE AS FALSE
	/*
	 * @Test public void listCategory() {
	 * 
	 * assertEquals("successfully fetched list of category from table",2,
	 * categoryDAO.list().size()); }
	 */

	@Test
	public void CRUDCategory() {

		// Add Category
		category = new Category();

		category.setName("Laptop");
		category.setDescription("Dell");
		category.setImageURL("4.jpg");

		assertEquals("success", true, categoryDAO.addCategory(category));

		category = new Category();

		category.setName("Mobile");
		category.setDescription("Iphone");
		category.setImageURL("3.jpg");

		assertEquals("success", true, categoryDAO.addCategory(category));

		category = new Category();

		category.setName("HeadSet");
		category.setDescription("JBL");
		category.setImageURL("7.jpg");

		assertEquals("success", true, categoryDAO.addCategory(category));

		// Update Category

		category = categoryDAO.getId(2);

		category.setName("Mobile");

		assertEquals("successfully updated single category from table", true, categoryDAO.updateCategory(category));

		// Delete Category

//		assertEquals("successfully DELETED single category from table", true, categoryDAO.deleteCategory(category));

		// Fetch Category With Active = True i,e 1
		assertEquals("successfully fetched list of category from table", 3, categoryDAO.list().size());
	}
}
