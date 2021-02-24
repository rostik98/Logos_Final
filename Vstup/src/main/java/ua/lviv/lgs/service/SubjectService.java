package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.SubjectRepository;
import ua.lviv.lgs.domain.Subject;

@Service
public class SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;

	public void save(Subject subject) {
		if (findByName(subject.getName()) == null) {
			subjectRepository.save(subject);
		}

	}

	public Subject findByName(String name) {
		return subjectRepository.findAll().stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().get();
	}

	public List<Subject> getAllSubjects() {
		return subjectRepository.findAll();
	}
}
