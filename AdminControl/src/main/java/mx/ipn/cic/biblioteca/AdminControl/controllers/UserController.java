package mx.ipn.cic.biblioteca.AdminControl.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mx.ipn.cic.biblioteca.AdminControl.model.UserModel;

@Controller
@RequestMapping("/user")
public class UserController {

	private List<UserModel> users;

	public UserController() {

		this.users = new ArrayList<>();
		this.users.add(new UserModel(1, "Manuel", "Pérez", "Santos", 29, "mi casa"));
		this.users.add(new UserModel(2, "Ernesto", "González", "Rodriguez", 26, "Su casa"));
		this.users.add(new UserModel(3, "Emanuel", "Sánchez", "Cruz", 28, "otra casa"));

	}

	// @RequestMapping(path = "/newUserForm",
	// method = RequestMethod.GET)
	@GetMapping(path = "/newForm")
	public ModelAndView newUserForm() {

		ModelAndView mav = new ModelAndView("users/newForm");
		return mav;

	}

	@GetMapping(path = "/all")
	public ModelAndView allUsers() {

		ModelAndView mav = new ModelAndView("users/all");
		mav.addObject("users", this.users);

		return mav;

	}

	@PostMapping(path = "/register")
	public String register(
			@RequestParam(name = "name") String name,
			@RequestParam(name = "lastnameP") String lastnameP,
			@RequestParam(name = "lastnameM") String lastnameM,
			@RequestParam(name = "age") int age,
			@RequestParam(name="address") String address
			) {

		// Proceso de registro
		
		UserModel user = new UserModel(name, lastnameP, lastnameM, age, address);
		this.users.add(user);

		return "redirect:/user/all";

	}

}
