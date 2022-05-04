package com.springtiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

	@RequestMapping(path = "/hello")
	public String toHelloWorld(Model model) {
		String message = "Welcome to 'SPRING TILES'!";
		model.addAttribute("message", message);
		return "hello";
	}
}
