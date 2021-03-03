package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.domain.Faculty;

@Service
public class FacultyService {
	@Autowired
	private FacultyRepository facultyRepository;

	public void save(Faculty faculty) {

		facultyRepository.save(faculty);

	}

	public void delete(Faculty faculty) {
		if (findByName(faculty.getName()) == null) {
			facultyRepository.delete(faculty);
		}
	}

	public Faculty findByName(String name) {
		return facultyRepository.findAll().stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().get();
	}

	public List<Faculty> getAllFaculties() {
		return facultyRepository.findAll();
	}
}
