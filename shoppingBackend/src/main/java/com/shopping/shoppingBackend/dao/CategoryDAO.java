package com.shopping.shoppingBackend.dao;

import java.util.List;

import com.shopping.shoppingBackend.dto.Category;

public interface CategoryDAO {

	Category getId(int id);	
	
	List<Category> list();
	
	public boolean addCategory(Category category);
	
	public boolean updateCategory(Category category);
	
	public boolean deleteCategory(Category category);
	
	
}
