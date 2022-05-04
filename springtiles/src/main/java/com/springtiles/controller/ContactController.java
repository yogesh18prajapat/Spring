package com.springtiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springtiles.model.Contact;

@Controller
@SessionAttributes
public class ContactController {
	
	@RequestMapping(path = "/addcontact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact) {
		//Coding to add Contact into DataBase.
		return "redirect:/contact";
	}
	
	@RequestMapping("/contact")
	public String showContacts(Model model) {
		String message = "Showing Contacts";
		model.addAttribute("message", message);
		return "contact";
	}
	
		
}
