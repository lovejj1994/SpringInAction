package spring.springmvc03.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.springmvc03.entity.Home;
import spring.springmvc03.repository.RegisterRepository;

@Controller
@RequestMapping(value = "/")
public class RegisterController {


	private RegisterRepository registerRepository;

	@Autowired
	public RegisterController(RegisterRepository registerRepository) {
		this.registerRepository = registerRepository;
	}

	// defaultValue 必须是String类型
	@RequestMapping(method = RequestMethod.GET,value="register")
	public String register() {
		return "registerForm";
	}

	@RequestMapping(method = RequestMethod.POST,value="register")
	public String home2(@Valid Home home,Errors errors) {
		//javax.validation 校验有错就跳转到注册页面
		if(errors.hasErrors()){
			return "redirect:registerForm";
		}
		Home save = registerRepository.save(home);
		return "redirect:/"+home.getUserName();
	}
	
	@RequestMapping(method = RequestMethod.GET,value="{username}")
	public String show(Model model, @PathVariable String username) {
		Home home = registerRepository.findHomeByUserName(username);
		model.addAttribute("home",home);
		return "success";
	}
}
