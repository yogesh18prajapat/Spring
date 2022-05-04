package springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("HomeController: /home called -> showing index.jsp");
		
		model.addAttribute("name", "batman");
		model.addAttribute("age",35);
		
		List<String> friends = new ArrayList<String>();
		friends.add("friend1");
		friends.add("friend2");
		friends.add("friend3");
		friends.add("friend4");
		model.addAttribute("friends",friends);

		return "index";
	}
	
	@RequestMapping("/about")
	public String about() {
		System.out.println("HomeController: /about called -> showing about.jsp");
		return "about";
	}
	
	@RequestMapping("/help")
	public ModelAndView help() {
		System.out.println("HomeController: /help called -> showing help.jsp");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name","superman");
		modelAndView.addObject("age",35);
		modelAndView.addObject("date", new Date());
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10001);
		numbers.add(10002);
		numbers.add(10003);
		numbers.add(10004);
		modelAndView.addObject("numbers",numbers);
		modelAndView.setViewName("help");
		return modelAndView;
	}
}
