package ua.lviv.lgs.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.domain.Mark;
import ua.lviv.lgs.service.EntrantDTOHelper;
import ua.lviv.lgs.service.EntrantService;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.SubjectService;

@Controller
public class EntrantController {
	@Autowired
	private EntrantService entrantService;

	@Autowired
	private SubjectService sService;

	@Autowired
	private FacultyService fService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("command", new Entrant());
		// model.addAttribute("userForm", new Entrant());
		return "registration";
	}

//	@RequestMapping(value = "/registration", method = RequestMethod.POST)
//	public String registration(@ModelAttribute("userForm") Entrant userForm, BindingResult bindingResult, Model model) {
//
//		if (bindingResult.hasErrors()) {
//			return "registration";
//		}
//		entrantService.save(userForm);
//
//		return "redirect:/home";
//	<spring:bind path="firstName">
//    <div class="form-group ${status.error ? 'has-error' : ''}">
//        <form:input type="text" path="firstName" class="form-control" placeholder="First name"
//                    autofocus="true"></form:input>
//        <form:errors path="firstName"></form:errors>
//    </div>
//</spring:bind>
//	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@RequestParam MultipartFile image, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam String password,
			@RequestParam String passwordConfirm) throws IOException {
		entrantService
				.save(EntrantDTOHelper.createEntity(image, firstName, lastName, email, password, passwordConfirm));

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

	@RequestMapping(value = "/admission", method = RequestMethod.GET)
	public String registrationq(Model model) {

		model.addAttribute("subjects", sService.getAllSubjects());
		model.addAttribute("marks", new ArrayList<Mark>());
		return "admission";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String welcome(Model m) {
		m.addAttribute("entrants", entrantService.getAllEntrants());
		m.addAttribute("subjects", sService.getAllSubjects());
		return "home";
	}

	@RequestMapping(value = "/chooseFaculty", method = RequestMethod.GET)
	public String hello(Model m) {
		m.addAttribute("userForm", new Entrant());
		m.addAttribute("FACULTIES", fService.getAllFaculties());
		return "chooseFaculty";
	}
}