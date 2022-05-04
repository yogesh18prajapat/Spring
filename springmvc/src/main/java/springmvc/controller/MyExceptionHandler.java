package springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {

/* ----------------- Handling Exception in Spring MVC------------------------- */

	
//If you want to handle particular type of exception
		@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler(value = NullPointerException.class)
		public String nullPointerException(Model m) {
		m.addAttribute("ecception","This is NullPointerClass");
		return "exception";
		}
		
		
//If you want to handle multiple types of exception
		@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler({ClassNotFoundException.class,NumberFormatException.class})
		public String multiException(Model m) {
		m.addAttribute("ecception","This is NullPointerClass");
		return "exception";
		}
			
//General Exception
		@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler(value = Exception.class)
		public String exception(Model m) {
		m.addAttribute("exception","Something went wrong");
		return "exception";
			}

}
