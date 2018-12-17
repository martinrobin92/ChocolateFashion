package com.shopping.shoppingBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.shoppingBackend.dao.ProductDAO;
import com.shopping.shoppingBackend.dto.Product;
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
@Autowired
private SessionFactory sessionFactory;
	@Override
	public Product getId(int productId) {
		
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
	}

	@Override
	public List<Product> getlist() {
		String list = "FROM Product";
		return sessionFactory.getCurrentSession().createQuery(list,Product.class).getResultList();
		
		
	}

	@Override
	public boolean addProduct(Product product) {
		sessionFactory.getCurrentSession().persist(product);
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);
		return true;
	}

	@Override
	public boolean deleteProduct(Product product) {
		product.setActive(false);
		sessionFactory.getCurrentSession().update(product);
		return true;
	}

	@Override
	public List<Product> listActiveProducts() {
String listActiveProducts = "FROM Product WHERE active = :active";
return sessionFactory
		.getCurrentSession()
		.createQuery(listActiveProducts , Product.class)
		.setParameter("active", true)
		.getResultList();
	
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryid) {
		String	listActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId =:categoryId";
		return sessionFactory.getCurrentSession().createQuery(listActiveProductsByCategory,Product.class).setParameter("active", true).setParameter("categoryId", categoryid).getResultList(); 
		
		
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM Product WHERE active = :active ORDER BY id",Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
