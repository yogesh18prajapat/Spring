//package com.springapp.controllers;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ControllerAdvice
//public class MyExceptionHandler {
//	
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value = Exception.class)
//	public String exceptionHandler(Model model,HttpSession session) {
//		model.addAttribute("exception", "Some error occured");
//		if (session.getAttribute("username") == null) {
//			return "main_page";
//		}
//		return "error";
//	}
//}
