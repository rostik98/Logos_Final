package ua.lviv.lgs.service;

import java.util.ArrayList;
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

	public List<Mark> getAllMarks() {
		return subjectRepository.findAll();
	}

	public void deleteById(Integer id) {
		subjectRepository.deleteById(id);
	}

	public List<Mark> saveAll(ArrayList<Mark> marks) {
		return subjectRepository.saveAll(marks);
	}
}
