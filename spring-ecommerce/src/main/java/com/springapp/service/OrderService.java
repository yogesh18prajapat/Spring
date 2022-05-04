package com.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springapp.dao.OrdersDao;
import com.springapp.entity.UserCart;
import com.springapp.entity.UserOrders;

@Service
public class OrderService {

	@Autowired
	private OrdersDao ordersDao;
	
	@Transactional
	public UserOrders getProductById(int productId) {
		return this.ordersDao.getProductById(productId);
		 
	}
	
	@Transactional
	public void addToOrders(int userId,UserCart uc) {
		this.ordersDao.addToOrders(userId, uc);
	}
	
	@Transactional
	public void addSingleProductToOrders(int userId,int productId) {
			this.ordersDao.addSingleProductToOrders(userId, productId);
		}
		
	@Transactional
	public List<UserOrders> getUserProducts(int userId) {
		return this.ordersDao.getUserProducts(userId);
	}
	
	@Transactional
	public void addingInBatchToOrders(int userId) {
		this.ordersDao.addingInBatchToOrders(userId);
	}
	
	

}
