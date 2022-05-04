package com.springapp.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
	//Redirecting from main_page to login Form
	@RequestMapping("/lform")
	public String showLoginForm(Model model) {
		model.addAttribute("title", "Login Form");
		return "login_form";
	}
	
	//index page to main page
	@RequestMapping("/main")
	public String showMainPage(Model model) {
		model.addAttribute("title", "Main page");
		return "main_page";
	}
	
	//Redirecting from main_page to Registration Form
	@RequestMapping("/new_user")
	public String register(Model m) {
		m.addAttribute("title", "Rigistration form");
		return "registration_form";
	}
	
	//Redirecting to home Page
	@RequestMapping("/home")
	public String toHome(HttpSession session) {
		if(session.getAttribute("username") == null){
			return "main_page";
		}
		return "home_page";
	}
	
	/*
	 * //showing cart for a user
	 * 
	 * @RequestMapping("/show_cart") public String displayCart(Model model) { return
	 * "cart_display"; }
	 */
	
	
//	  //showing cart for a user
//	  @RequestMapping("/show_orders")
//	  public String displayOrders(Model model) {
//	  return "orders_display";
//	  }
	 
	
	//To Payments page
		@RequestMapping("do_payment")
		public String payment(Model model,HttpSession session) {
			if(session.getAttribute("username") == null){
				return "main_page";
			}
			return "payment_page";
		}
	
	
}
