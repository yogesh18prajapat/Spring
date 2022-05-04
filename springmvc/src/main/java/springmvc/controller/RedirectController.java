package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {
	
	//Using redirect:prefix -> [redirect:/url]
	@RequestMapping("/one")
	public String one() {
//		System.out.println("RedirectController: /one  -> /two");
	//this will redirect to HomeController: /home 
		return "redirect:/two";
	}
	
	//Using RedirectView -> [RedirectView rv -> rv.setUrl(url)]
	@RequestMapping("/two")
	public RedirectView two() {
		RedirectView rv = new RedirectView();
		rv.setUrl("home"); //don't use slash 
//		System.out.println("RedirectController: /two  -> /home");
		return rv;
	}
}
