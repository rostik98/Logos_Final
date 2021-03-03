package ua.lviv.lgs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.EnrolledRepository;
import ua.lviv.lgs.domain.Enrolled;

@Service
public class EnrolledService {
	@Autowired
	private EnrolledRepository enrolledRepository;

	public void save(Enrolled enrolled) {

		enrolledRepository.save(enrolled);

	}
}
