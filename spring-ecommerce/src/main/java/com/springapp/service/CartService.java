package com.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springapp.dao.CartDao;
import com.springapp.entity.UserCart;

@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao;
	
	@Transactional
	public UserCart getProductById(int productId) {
		UserCart uc = this.cartDao.getProductById(productId);
		return uc;
	}
	
	@Transactional
	public List<UserCart> getUserProducts(String username) {
		return this.cartDao.getUserProducts(username);
	}
	
	@Transactional
	public void addToCart(String username, int productId) {
		this.cartDao.addToCart(username, productId);
	}
	
//	@Transactional
//	public UserCart containsProduct(String username, int productId) {
//		return this.cartDao.containsProduct(username, productId);
//	}
//	
//	@Transactional
//	public void updateQuantity(String username, int productId, boolean increment) {
//		this.cartDao.updateQuantity(username, productId, increment);
//	}
//	
//	@Transactional
//	public void deleteProductFromCart(String username, int productId) {
//		this.cartDao.deleteProduct(username, productId);
//	}
	
	@Transactional
	public boolean containsProduct(int userId, int productId) {
		return this.cartDao.containsProduct(userId, productId);
	}
	@Transactional
	public UserCart getUserCartProduct(int userId, int productId) {
		return this.cartDao.getUserCartProduct(userId, productId);
	}
	@Transactional
	public boolean deleteUserCartProduct(int userId, int productId) {
		return this.cartDao.deleteUserCartProduct(userId, productId);
	}
	
	@Transactional
	public void updateUserCartProduct(int userId, int productId, boolean increment) {
		this.cartDao.updateUserCartProduct(userId, productId, increment);
	}
	
	@Transactional
	public void  deleteAllFromCart(int userId) {
		this.cartDao.deleteAllFromCart(userId);
	}
	
	
}
