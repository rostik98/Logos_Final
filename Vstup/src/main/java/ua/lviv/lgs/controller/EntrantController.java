package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.service.EntrantService;

@Controller
public class EntrantController {
	@Autowired
	private EntrantService entrantService;

//	@Autowired
//	private SubjectService suService;
//
//	@Autowired
//	private FacultyService faService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new Entrant());
//		Subject s = new Subject("Ukrainian language");
//		suService.save(s);
//		suService.save(new Subject("Ukrainian literature"));
//		suService.save(new Subject("Algebra"));
//		suService.save(new Subject("Geometry"));
//		suService.save(new Subject("Physic"));
//		suService.save(new Subject("Geography"));
//		suService.save(new Subject("Biology"));
//		suService.save(new Subject("History"));
//		suService.save(new Subject("Chemistry"));
//		suService.save(new Subject("Informatics"));
//		suService.save(new Subject("Physical training"));
//		suService.save(new Subject("National defense"));
//		suService.save(new Subject("English"));
//		suService.save(new Subject("Astronomy"));
//		//
//		faService.save(new Faculty("Faculty 1", 8.5, 78));
//		faService.save(new Faculty("Faculty 2", 9.7, 180));
//		faService.save(new Faculty("Faculty 3", 7.9, 54));

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") Entrant userForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "registration";
		}
		entrantService.save(userForm);

		return "redirect:/home";
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String welcome(Model model) {
		return "home";
	}

}