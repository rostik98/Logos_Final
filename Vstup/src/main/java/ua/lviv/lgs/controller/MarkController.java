package ua.lviv.lgs.controller;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Mark;
import ua.lviv.lgs.service.EntrantService;
import ua.lviv.lgs.service.MarkService;
import ua.lviv.lgs.service.SubjectService;

@Controller
public class MarkController {
	@Autowired
	private MarkService markService;
	@Autowired
	private EntrantService eService;
	@Autowired
	private SubjectService sService;

	@RequestMapping(value = "/admission", method = RequestMethod.POST)
	public ModelAndView createPeriodical(@ModelAttribute("marks") ArrayList<Mark> marks, HttpServletRequest request,
			Principal principal, BindingResult bindingResult) {
		for (int i = 0; i < sService.getAllSubjects().size(); i++) {
			Integer parameter1 = Integer
					.parseInt(request.getParameter("subject" + sService.getAllSubjects().get(i).getId()));
			marks.add(new Mark(eService.getOneByEmail(principal.getName()), sService.findById(parameter1),
					Integer.parseInt(request.getParameter("value" + sService.getAllSubjects().get(i).getId()))));

		}
		markService.saveAll(marks);
		return new ModelAndView("redirect:/home");
	}
}
