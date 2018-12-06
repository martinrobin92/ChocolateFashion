package com.shopping.shoppingBackend.daoimpl;

import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Repository;

import com.shopping.shoppingBackend.dao.CategoryDAO;
import com.shopping.shoppingBackend.dto.Category;
@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category cat = new Category();
		cat.setId(1);
		cat.setName("Laptop");
		cat.setDescription(" intel inside i8");
		cat.setImageURL("rob.png");
		
		categories.add(cat);
		Category cat1 = new Category();
		cat1.setId(2);
		cat1.setName("Phone");
		cat1.setDescription("Only Iphones");
		cat1.setImageURL("ro.png");
		
		categories.add(cat1);
		Category cat2 = new Category();
		cat2.setId(7);
		cat2.setName("Headset");
		cat2.setDescription("Only MI");
		cat2.setImageURL("ron.png");
		
		categories.add(cat2);
	}
	
	
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}




	@Override
	public Category getId(int id) {
		for(Category category : categories) {
			if(category.getId() ==  id) return category;
		}
		return null;
	}

}
