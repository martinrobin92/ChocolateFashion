package com.shopping.shoppingBackend.dao;

import java.util.List;

import com.shopping.shoppingBackend.dto.Product;

public interface ProductDAO {

	Product getId(int productId);
	List<Product> getlist();
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	
	//Business Methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryid);
	List<Product> getLatestActiveProducts(int count);
	
	
}
