package com.shopping.shoppingBackend.dao;

import java.util.List;

import com.shopping.shoppingBackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();

	Category getId(int id);	
	
}
