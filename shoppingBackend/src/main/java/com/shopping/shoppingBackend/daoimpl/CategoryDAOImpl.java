package com.shopping.shoppingBackend.daoimpl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.shoppingBackend.dao.CategoryDAO;
import com.shopping.shoppingBackend.dto.Category;
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
@Autowired
private SessionFactory sessionFactory;
	
	
	
	
	
	/*@Override
	public List<Category> list() {
		String isActive = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(isActive);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}*/
	
	@Override
	public List<Category> list() {
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Category.class);
		cr.add(Restrictions.eq("active", true));
		return cr.list();
		
	}



/** GETTING SINGLE CATEGORY BASED ON ID */
	@Override
	public Category getId(int id) {
	return 	sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}




	@Override
	public boolean addCategory(Category category) {
		
		sessionFactory.getCurrentSession().persist(category);;
		return true;
	}




@Override
public boolean updateCategory(Category category) {
	sessionFactory.getCurrentSession().update(category);;
	return true;
}




@Override
public boolean deleteCategory(Category category) {
	
	category.setActive(false);
	
	sessionFactory.getCurrentSession().update(category);;
	return true;
}






}
