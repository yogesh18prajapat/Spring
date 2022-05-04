package com.springapp.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springapp.entity.Product;
import com.springapp.entity.UserCart;
import com.springapp.service.CartService;
import com.springapp.service.ProductService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private ProductService productService;

	// Adding product to cart(Products_list or product_Description)
		@RequestMapping("add_to_cart/{id}/{section}")
		public String addToCart(@PathVariable("id") int productId, @PathVariable("section") String section, Model model,
				HttpSession session) {
			String username = session.getAttribute("username").toString();
			int userId = Integer.parseInt(session.getAttribute("userid").toString());
			UserCart userCartProduct = this.cartService.getUserCartProduct(userId, productId);
			if (userCartProduct == null) {
				this.cartService.addToCart(username, productId);
			} else {
				this.cartService.updateUserCartProduct(userId, productId, true);
			}
			return "redirect:/after_adding_product/" + section;

		}

		// Adding product to cart(Products_list or product_Description)
		@RequestMapping("update_in_cart/{id}/{section}/{update}")
		public String updating(@PathVariable("id") int productId, @PathVariable("section") String section, Model model,
				@PathVariable("update") boolean increment,
				HttpSession session) {
			//session attributes
//			String username = session.getAttribute("username").toString();
			int userId = Integer.parseInt(session.getAttribute("userid").toString());
			UserCart userCartProduct = this.cartService.getUserCartProduct(userId, productId);
			System.out.println("CartController.updating() --------> "+productId);
			if (userCartProduct != null) {
				if(increment){
				this.cartService.updateUserCartProduct(userId, productId, true);
			} else {
				if(userCartProduct.getQuantity() == 1) {
					this.cartService.deleteUserCartProduct(userId, productId);
				}else {
				this.cartService.updateUserCartProduct(userId,productId, false);
				}
			}
			}
				return "redirect:/show_cart"; 
			}
			

	// Redirection productslist after adding product
	@RequestMapping("/after_adding_product/{section}")
	public String afterAddingToCart(@PathVariable("section") String section, Model model) {
		List<Product> products = this.productService.getProducts(section);
		model.addAttribute("title", "Product List");
		model.addAttribute("alert", "alert('Product added successfully to CART')");
		model.addAttribute("products", products);
		return "productslist";
	}

	// Displaying User Cart page
	@RequestMapping("/show_cart")
	public String displaying_cart_page(Model model, HttpSession session, RedirectAttributes ra) {
		if (session.getAttribute("username") == null) {
			return "main_page";
		}
		String username = session.getAttribute("username").toString();
		List<UserCart> userProducts = this.cartService.getUserProducts(username);
		ra.addFlashAttribute("userProducts", userProducts);
		model.addAttribute("products", userProducts);
		return "cart_display";
	}



//***********************************************************************************************	

	

}
