package ua.lviv.lgs.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.EnrolledRepository;
import ua.lviv.lgs.domain.Enrolled;
import ua.lviv.lgs.domain.Faculty;

@Service
public class EnrolledService {
	@Autowired
	private EnrolledRepository enrolledRepository;

	public void save(Enrolled enrolled) {

		enrolledRepository.save(enrolled);

	}

	public Integer getAllEnrolledsOnFaculty(Faculty f) {
		return enrolledRepository.findAll().stream().filter(x -> x.getFacultyId().equals(f))
				.collect(Collectors.toList()).size();
	}
}
