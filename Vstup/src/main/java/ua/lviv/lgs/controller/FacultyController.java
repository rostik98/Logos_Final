package ua.lviv.lgs.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.lviv.lgs.domain.Enrolled;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Mark;
import ua.lviv.lgs.service.EnrolledService;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.MarkService;

@Controller
public class FacultyController {

	@Autowired
	private MarkService mService;
	@Autowired
	private FacultyService fService;
	@Autowired
	private EnrolledService enrolledService;

	@RequestMapping(value = "/chooseFaculty", method = RequestMethod.POST)
	public String registration(@ModelAttribute("FACULTIES") ArrayList<Faculty> userForm, Principal p,
			HttpServletRequest request, BindingResult bindingResult, Model model) {
		List<Mark> filter = mService.getAllMarks().stream().filter(x -> x.getEntrant().getEmail().equals(p.getName()))
				.collect(Collectors.toList());
		Faculty findByName = fService.findByName(request.getParameter("name"));
		Integer nofEnrolleds = enrolledService.getAllEnrolledsOnFaculty(findByName);

		if (nofEnrolleds >= findByName.getBudgetPlaces()) {
			return "redirect:/home?noPlaces";
		}
		Iterator<Mark> iterator = mService.getAllMarks().stream()
				.filter(x -> x.getEntrant().getEmail().equals(p.getName())).collect(Collectors.toList()).iterator();
		double avg = 0;
		int cout = 0;
		while (iterator.hasNext()) {
			Mark mark = (Mark) iterator.next();
			{
				avg += mark.getValue();
				cout++;

			}
		}
		avg /= cout;
		if (avg < findByName.getPassingScore()) {
			return "redirect:/home?badPass";
		}
		enrolledService.save(new Enrolled(findByName, filter.get(0).getEntrant(), avg));
		return "redirect:/home";
	}
}
