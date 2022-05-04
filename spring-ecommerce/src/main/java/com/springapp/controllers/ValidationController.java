package com.springapp.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.springapp.entity.User;
import com.springapp.service.UserService;

@Controller
public class ValidationController {

	@Autowired
	private UserService userService;
	
	//Saving data if it is a new user
	@RequestMapping("/registervalidation/{user}")
	public String registerUser(@ModelAttribute("user") User u, Model model) {
		User user = (User) u;
//		u.setId(1);
		System.out.println(user);
		this.userService.save(user);
		return "redirect:/lform";
	}

	//Checking if username is valid or not
	@RequestMapping(path = "/validate", method = RequestMethod.POST)
	public RedirectView validateNewUser(@ModelAttribute User user, Model model, RedirectAttributes redirectAttributes) {
		RedirectView rv = new RedirectView();
		if (this.userService.containsUser(user)) {
			model.addAttribute("invalid","username already exists");
			rv.setUrl("new_user");
			return rv;
		}
		redirectAttributes.addFlashAttribute("user", user);
		rv.setUrl("registervalidation/" + user);
		return rv;
	}

	//from user_update_details to profilr after editing user details
	@RequestMapping("/update_details/{id}")
	public String updatingDetails(@PathVariable("id") String id, @ModelAttribute User user, Model model) {
		user.setId(Integer.parseInt(id));
		this.userService.save(user);
		return "profile";
	}
	
	//Login Validation
	@RequestMapping("/login")
	public String loginValidation(@ModelAttribute User user,Model model, HttpSession session) {
		String result = this.userService.isValid(user.getUsername(), user.getPassword());
		if(result.equals("valid")) {
			int userId = this.userService.getUserId(user.getUsername());
			//Creating session
			session.setAttribute("username",user.getUsername());
			session.setAttribute("userid",userId);
			return "home_page";
		}else if(result.equals("invalid_username")) {
			model.addAttribute("invalid","alert('invalid username')");
		}else {
		model.addAttribute("invalid","alert('invalid password')");
		}
		return "login_form";
	}
	
	//logout Session
	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.removeAttribute("username");
		model.addAttribute("message","Logout Successful");
		return "main_page";
	}
}
