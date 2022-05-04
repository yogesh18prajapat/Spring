package com.springapp.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springapp.entity.User;
import com.springapp.service.UserService;

@Controller
public class RedirectController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/already_exist")
	public String exists() {
		return "registration_form";
	}
	
	//from profile page to edit update_user_details form
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id") int id, Model model) {
		User user = this.userService.getUserById(id);
		model.addAttribute("title","Edit user information");
		model.addAttribute("user",user);
		return "update_user_details";
	}
	
	//Redirect to profile page
	@RequestMapping("/profile_page")
	public String toProfile(Model model, HttpSession session) {
		if(session.getAttribute("username") == null){
			return "main_page";
		}
		String username = (String)session.getAttribute("username");
		User user = this.userService.getUserByUsername(username);
		System.out.println(user);
		model.addAttribute("user", user);
		return "profile";
	}
	
}
