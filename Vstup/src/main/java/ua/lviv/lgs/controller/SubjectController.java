package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.domain.Mark;
import ua.lviv.lgs.service.MarkService;

@Controller
public class SubjectController {
	@Autowired
	private MarkService markService;
//	@Autowired
//	private EntrantService mService;
//	@Autowired
//	private SubjectService maService;

	@RequestMapping(value = "/admission", method = RequestMethod.POST)
	public ModelAndView createPeriodical(@ModelAttribute("mark") Mark mark,
			@ModelAttribute("userForm") Entrant userForm, BindingResult bindingResult) {
		mark.setEntrantId(userForm);
		System.out.println("pidor " + userForm);
		markService.save(mark);
		return new ModelAndView("redirect:/home");
	}

//	@RequestMapping(value = "/admission", method = RequestMethod.GET)
//	public String registrationq(Model model) {
//		model.addAttribute("marks", new Mark());
//		model.addAttribute("user", new Entrant());
//		model.addAttribute("subject", new Subject());
//
//		return "admission";
//	}
//
//	@RequestMapping(value = "/admission", method = RequestMethod.POST)
//	public String registrationq(@ModelAttribute("marks") Mark userForm, BindingResult bindingResult, Model model) {
//
//		if (bindingResult.hasErrors()) {
//			return "home";
//		}
//		Entrant user = new Entrant(1, "Ростислав", "Шеремета", "sheremeta967@ukr.net", "1");
//		mService.save(user);
////		Subject s = new Subject(6, "Math");
////		maService.findByName("Math");
//		userForm.setEntrantId(user);
//		userForm.setSubjectId(maService.findByName("Math"));
//		markService.save(userForm);
//
//		return "redirect:/home";
//	}

//	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
//	public String login(Model model, String error, String logout) {
//		if (error != null)
//			model.addAttribute("error", "Your username and password is invalid.");
//
//		if (logout != null)
//			model.addAttribute("message", "You have been logged out successfully.");
//
//		return "login";
//	}
//
//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public String welcome(Model model) {
//		return "home";
//	}
//
//	@RequestMapping(value = "/admission", method = RequestMethod.GET)
//	public String regToFaculty(Model model) {
//		return "admission";
//	}
}
