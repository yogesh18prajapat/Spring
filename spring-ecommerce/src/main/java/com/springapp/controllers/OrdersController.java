package com.springapp.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springapp.entity.UserOrders;
import com.springapp.service.CartService;
import com.springapp.service.OrderService;

@Controller
public class OrdersController {
	
	@Autowired
	private OrderService ordersService;

	@Autowired
	private CartService cartService;

	
	//To add products from cart
	@RequestMapping("/add_to_orders")
	public String addBatchToOrders(Model model,HttpSession session) {
		int userid =Integer.parseInt(session.getAttribute("userid").toString());
		this.ordersService.addingInBatchToOrders(userid);
		return "redirect:/delete_from_cart";
	}
	
	//Deleting from cart
	@RequestMapping("/delete_from_cart")
	public String deletingFromoCart(Model model,HttpSession session) {
		int userid =Integer.parseInt(session.getAttribute("userid").toString());
		this.cartService.deleteAllFromCart(userid);
		return "success";
	}
	
	//when user clicks buynow(adding product to orders)
	@RequestMapping("/buy_now/{id}")
	public String buyNow(@PathVariable("id") int productId, Model model, HttpSession session) {
		int userid =Integer.parseInt(session.getAttribute("userid").toString());
		this.ordersService.addSingleProductToOrders(userid, productId);
		return "success";
	}
	
	//Redirecting from products to payments page
	@RequestMapping("/buy_product/{id}")
	public String buyingSingleProduct(@PathVariable("id") int productId, Model model, HttpSession session) {
		if (session.getAttribute("username") == null) {
			return "main_page";
		}
		model.addAttribute("productId", productId);
		return "buy_now_payments";
	}
	

	 //showing cart for a user
	 @RequestMapping("/show_orders")
	 public String displayOrders(Model model,HttpSession session) {
		 
			if (session.getAttribute("username") == null) {
				return "main_page";
			}
	 
		int userid =Integer.parseInt(session.getAttribute("userid").toString());
		List<UserOrders> userProducts = this.ordersService.getUserProducts(userid);
		model.addAttribute("title","Orders Page");
		model.addAttribute("products",userProducts);
		  return "orders_display";
	  }

}
