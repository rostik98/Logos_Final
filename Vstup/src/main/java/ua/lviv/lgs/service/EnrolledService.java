package ua.lviv.lgs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.EnrolledRepository;
import ua.lviv.lgs.domain.Enrolled;

@Service
public class EnrolledService {
	private Logger logger = LoggerFactory.getLogger(EnrolledService.class);

	@Autowired
	private EnrolledRepository enrolledRepository;

	public void save(Enrolled enrolled) {
		logger.info("Save entrant {0} to enrolleds table", enrolled);
		enrolledRepository.save(enrolled);

	}
}
