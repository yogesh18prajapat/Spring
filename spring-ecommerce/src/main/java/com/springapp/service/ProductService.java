package com.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springapp.dao.ProductDao;
import com.springapp.entity.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	@Transactional
	public void insert(Product product) {
		this.productDao.insert(product);

	}
	
	@Transactional
	public Product getProductById(int productId) {
		Product p = this.productDao.getProductById(productId);
		return p;
	}
	
	@Transactional
	public List<Product> getProducts(String section){
		List<Product> sectionProducts = this.productDao.getSectionProducts(section);
		return sectionProducts;
	}
	

}
