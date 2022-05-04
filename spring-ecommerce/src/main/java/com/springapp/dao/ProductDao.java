package com.springapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.springapp.entity.Product;

@Repository
public class ProductDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	public void insert(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);

	}
	
	public Product getProductById(int productId) {
		Product p = this.hibernateTemplate.get(Product.class, productId);
		return p;
	}
	
	public List<Product> getSectionProducts(String section) {
		List<Product> sectionProducts = new ArrayList<Product>();
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		for(Product p : products) {
			if(p.getSection().equals(section)) {
				sectionProducts.add(p);
			}
		}
		return sectionProducts;
	}
	
	
//	public int getQuantity(int productId) {
//		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
//		for(Product x : products ) {
//			if(productId == x.getId()){
//				return x.getQuantity();
//			}
//		}
//		return 1;
//	}
//	


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}