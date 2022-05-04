package com.springapp.controllers;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springapp.entity.Product;
import com.springapp.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/mens_product")
	public String mensPLP(Model model) {
		
		return "productlist_page";
	}
	
	//Adding products into DB by 'ADMIN'
	@RequestMapping("/add_product")
	public String addProductToDB(@ModelAttribute("product") Product product, Model model) {
		this.productService.insert(product);
		return "add_product";
	}
	
	@RequestMapping("/product_list_page/{section}")
	public String ProductListPage(@PathVariable("section") String section, Model model,HttpSession session) {
		if(session.getAttribute("username") == null){
			return "main_page";
		}
		List<Product> products = this.productService.getProducts(section);
		model.addAttribute("title","Product List");
		model.addAttribute("products", products);
		return "productslist";
	}
	
	@RequestMapping("product_description/{id}")
	public String productDescriptionPage(@PathVariable("id") int id, Model model,HttpSession session) {
		
		if(session.getAttribute("username") == null){
			return "main_page";
		}
		
		Product product = this.productService.getProductById(id);
		model.addAttribute("title","Product Description");
		model.addAttribute("product",product);
		return "product_description_page";
	}
}
