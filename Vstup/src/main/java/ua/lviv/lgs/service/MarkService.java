package ua.lviv.lgs.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.MarkRepository;
import ua.lviv.lgs.domain.Mark;

@Service
public class MarkService {
	private Logger logger = LoggerFactory.getLogger(MarkService.class);

	@Autowired
	private MarkRepository subjectRepository;

	public Mark save(Mark mark) {
		logger.info("Save entrants mark {0} to DB", mark);
		return subjectRepository.save(mark);
	}

	public List<Mark> getAllMarks() {
		logger.info("Get all marks");
		return subjectRepository.findAll();
	}

	public void deleteById(Integer id) {
		logger.info("Delete mark by id " + id);
		subjectRepository.deleteById(id);
	}

	public List<Mark> saveAll(ArrayList<Mark> marks) {
		logger.info("Save all marks of some entrant");
		return subjectRepository.saveAll(marks);
	}
}
