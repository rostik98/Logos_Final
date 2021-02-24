package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.MarkRepository;
import ua.lviv.lgs.domain.Mark;

@Service
public class MarkService {
	@Autowired
	private MarkRepository subjectRepository;

	public Mark save(Mark subject) {
		return subjectRepository.save(subject);
	}

	public List<Mark> getAllSubjects() {
		return subjectRepository.findAll();
	}
}
