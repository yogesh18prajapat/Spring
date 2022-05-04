package com.springapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.springapp.entity.Product;
import com.springapp.entity.User;
import com.springapp.entity.UserCart;
import com.springapp.service.UserService;

@Repository
public class CartDao {

	@Autowired
	private UserService userService;

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

	// To get single product from usercart
	public UserCart getProductById(int productId) {
		UserCart uc = this.hibernateTemplate.get(UserCart.class, productId);
		return uc;
	}

	// To add product to usercart
	public void addToCart(String username, int productId) {
		Product product = this.productDao.getProductById(productId);
		User user = (User) this.userService.getUserByUsername(username);
		UserCart user_cart_product = new UserCart();
		user_cart_product.setProductId(productId);
		user_cart_product.setDescription(product.getDescription());
		user_cart_product.setImg(product.getImg());
		user_cart_product.setName(product.getName());
		user_cart_product.setPrice(product.getPrice());
		user_cart_product.setQuantity(product.getQuantity() + 1);
		user_cart_product.setSection(product.getSection());
		user_cart_product.setUser(user);
		this.hibernateTemplate.save(user_cart_product);
	}

	// Returs List of user cart products
	public List<UserCart> getUserProducts(String username) {
		List<UserCart> user_products = new ArrayList<UserCart>();
		int id = this.userService.getUserId(username);
		List<UserCart> uc_products = this.hibernateTemplate.loadAll(UserCart.class);
		for (UserCart uc : uc_products) {
			User user = uc.getUser();
			if (user.getId() == id) {
				user_products.add(uc);
			}
		}
		return user_products;
	}
	
//	does cart contain's particular product
	public boolean containsProduct(int userId, int productId) {
		List<UserCart> userProducts = this.hibernateTemplate.loadAll(UserCart.class);
		for(UserCart uc : userProducts) {
			if((uc.getUser().getId() == userId) && uc.getProductId() == productId ) {
				return true;
			}
		}
		return false;
	}

//	To get single cart product
	public UserCart getUserCartProduct(int userId, int productId) {
		List<UserCart> userProducts = this.hibernateTemplate.loadAll(UserCart.class);
		for(UserCart uc : userProducts) {
			if((uc.getUser().getId() == userId) && uc.getProductId() == productId ) {
				return uc;
			}
		}
		return null;
	}
	
// 	Delete product from user cart
	public boolean deleteUserCartProduct(int userId, int productId) {
		UserCart ucp = getUserCartProduct(userId, productId);
		if(ucp != null) {
			this.hibernateTemplate.delete(ucp);
			return true;
		}
		return false;
	}
	
//	update product quantity in user cart
	public void updateUserCartProduct(int userId, int productId, boolean increment) {
		UserCart ucp = getUserCartProduct(userId, productId);
		if(ucp != null) {
			if(increment) {
			ucp.setQuantity(ucp.getQuantity() + 1);
			}else {
				ucp.setQuantity(ucp.getQuantity() - 1);	
			}
			this.hibernateTemplate.update(ucp);
		}
	}
	
//	To delete products from cart
	public void  deleteAllFromCart(int userId) {
		User user = (User) this.userService.getUserById(userId);
		List<UserCart> userProducts = getUserProducts(user.getUsername());
		for(UserCart up : userProducts) {
			this.hibernateTemplate.delete(up);
		}
	}
	

}


//// does cart contain's particular product
//public UserCart containsProduct(String username, int productId) {
//	int userId = this.userService.getUserId(username);
//	List<UserCart> uc_products = this.hibernateTemplate.loadAll(UserCart.class);
//	System.out.println("CartDao.containsProduct() -> before for loop");
//		for (UserCart uc : uc_products) {
//		int cartProductId = uc.getProductId();
//		int cartUserId = uc.getUser().getId();
//		if ((cartUserId == userId) && (cartProductId == productId)) {
//			System.out.println("CartDao.containsProduct() -> in for loop...........");
//			return uc;
//		}
//	}
//		System.out.println("CartDao.containsProduct() -> after for loop returning null");
//	return null;
//}
//
//// update product quantity in user cart
//	public void updateQuantity(String username, int productId, boolean increment) {
//		UserCart ucp = containsProduct(username, productId);
//			
//			if (increment) {
//				ucp.setQuantity(ucp.getQuantity() + 1);
//			} else {
//				if (ucp.getQuantity() == 1) {
//					deleteProduct(username, productId);
//				} else {
//					ucp.setQuantity(ucp.getQuantity() - 1);
//				}
//			}
//			this.hibernateTemplate.update(ucp);
//	}
//
//	
//	
//// Delete product from user cart
//	public void deleteProduct(String username, int productId) {
//		UserCart ucp = containsProduct(username, productId);
//		this.hibernateTemplate.delete(ucp);
//	}
