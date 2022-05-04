package com.springapp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.springapp.entity.Product;
import com.springapp.entity.User;
import com.springapp.entity.UserCart;
import com.springapp.entity.UserOrders;
import com.springapp.service.CartService;
import com.springapp.service.UserService;

@Repository
public class OrdersDao {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

//---------------------------------------------------------------------------------------

	// To get single product from userorders
	public UserOrders getProductById(int productId) {
		UserOrders uo = this.hibernateTemplate.get(UserOrders.class, productId);
		return uo;
	}

	// To add product to userorders
	public void addToOrders(int userId,UserCart uc) {
		User user = (User)this.userService.getUserById(userId);
		//assigning values to orders object by cart products
		UserOrders user_order_product = new UserOrders();
		user_order_product.setProductId(uc.getProductId());
		user_order_product.setDescription(uc.getDescription());
		user_order_product.setImg(uc.getImg());
		user_order_product.setName(uc.getName());
		user_order_product.setPrice(uc.getPrice());
		user_order_product.setQuantity(uc.getQuantity());
		user_order_product.setSection(uc.getSection());
		user_order_product.setDate(new Date());		
		user_order_product.setUser(user);
		this.hibernateTemplate.save(user_order_product);
	}
	
	// To add product to userorders
		public void addSingleProductToOrders(int userId,int productId) {
			User user = (User)this.userService.getUserById(userId);
			Product product = this.productDao.getProductById(productId);
			//assigning values to orders object by product list on 'BUY NOW'
			UserOrders user_order_product = new UserOrders();
			user_order_product.setProductId(productId);
			user_order_product.setDescription(product.getDescription());
			user_order_product.setImg(product.getImg());
			user_order_product.setName(product.getName());
			user_order_product.setPrice(product.getPrice());
			user_order_product.setQuantity(product.getQuantity()+1);
			user_order_product.setSection(product.getSection());
			user_order_product.setDate(new Date());		
			user_order_product.setUser(user);
			this.hibernateTemplate.save(user_order_product);
		}
		
	
	
	// Returs List of user order products
	public List<UserOrders> getUserProducts(int userId) {
		List<UserOrders> user_orders_products = new ArrayList<UserOrders>();
		List<UserOrders> uo_products = this.hibernateTemplate.loadAll(UserOrders.class);
		for (UserOrders userorder : uo_products) {
			if (userorder.getUser().getId() == userId) {
				user_orders_products.add(userorder);
			}
		}
		return user_orders_products;
	}
	
	//Adding all cart items to orders
	public void addingInBatchToOrders(int userId) {
		User user = this.userService.getUserById(userId);
		 List<UserCart> cartProducts = this.cartService.getUserProducts(user.getUsername());
		 for(UserCart uc : cartProducts) {
			 addToOrders(userId,uc);
		 }
	}
	
	

	
}
