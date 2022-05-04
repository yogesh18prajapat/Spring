package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ExceptionController {
	//Handling Exception in Spring MVC
	
	@ExceptionHandler(value = NullPointerException.class)
	public String nullPointerException() {
		return "exception";
	}
}
