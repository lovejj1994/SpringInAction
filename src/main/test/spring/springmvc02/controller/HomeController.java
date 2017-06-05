package spring.springmvc02.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.springmvc02.repository.HomeRepository;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	private static final String MAX_LONG_AS_STRING = Long.MAX_VALUE + "";

	private HomeRepository homeRepository;

	@Autowired
	public HomeController(HomeRepository homeRepository) {
		this.homeRepository = homeRepository;
	}

	// defaultValue 必须是String类型
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model, @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {
		model.addAttribute("homesList", homeRepository.findHomes(max, count));
		return "home";
	}

	@RequestMapping(method = RequestMethod.GET,value="/{id}")
	public String home2(Model model,@PathVariable long id) {
		model.addAttribute("home", homeRepository.findOne(id));
		return "home";
	}
}
