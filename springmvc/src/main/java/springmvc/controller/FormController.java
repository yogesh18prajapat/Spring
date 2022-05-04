package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class FormController {
	@Autowired
	private UserService userService;
	
	
	@ModelAttribute
	public void CommonData(Model mod) {
		mod.addAttribute("heading","This is a header");
		mod.addAttribute("description","This is a description");
	}
	
	@RequestMapping("/form")
	public String view() {
//		String str = null;
//		str.charAt(0);
		return "userform";
	}
	
	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleRequest(@ModelAttribute User user, Model model) {
		this.userService.createUser(user);
		return "success";
	}
	
	
/* ----------------- Handling Exception in Spring MVC------------------------- */

	
////If you want to handle particular type of exception
//		@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//		@ExceptionHandler(value = NullPointerException.class)
//		public String nullPointerException(Model m) {
//			m.addAttribute("ecception","This is NullPointerClass");
//			return "exception";
//		}
//	
//	
////If you want to handle multiple types of exception
//		@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//		@ExceptionHandler({ClassNotFoundException.class,NumberFormatException.class})
//		public String multiException(Model m) {
//			m.addAttribute("ecception","This is NullPointerClass");
//			return "exception";
//		}
//		
////General Exception
//		@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//		@ExceptionHandler(value = Exception.class)
//		public String exception(Model m) {
//		m.addAttribute("exception","Something went wrong");
//			return "exception";
//		}

}
