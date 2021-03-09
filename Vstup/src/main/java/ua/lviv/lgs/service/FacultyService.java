package ua.lviv.lgs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.domain.Faculty;

@Service
public class FacultyService {
	private Logger logger = LoggerFactory.getLogger(FacultyService.class);

	@Autowired
	private FacultyRepository facultyRepository;

	public void save(Faculty faculty) {
		logger.info("Create new Faculty " + faculty);
		facultyRepository.save(faculty);

	}

	public void delete(Faculty faculty) {
		logger.info("Delete Faculty " + faculty);
		if (findByName(faculty.getName()) == null) {
			facultyRepository.delete(faculty);
		}
	}

	public Faculty findByName(String name) {
		logger.info("Get Faculty by name " + name);
		return facultyRepository.findAll().stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().get();
	}

	public List<Faculty> getAllFaculties() {
		logger.info("Get all Faculties");
		return facultyRepository.findAll();
	}
}
