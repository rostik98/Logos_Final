package ua.lviv.lgs;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.EnrolledRepository;
import ua.lviv.lgs.dao.EntrantRepository;
import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.dao.MarkRepository;
import ua.lviv.lgs.dao.SubjectRepository;
import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.service.EnrolledService;
import ua.lviv.lgs.service.EntrantService;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.MarkService;
import ua.lviv.lgs.service.SubjectService;

@RunWith(SpringRunner.class)
@DataJpaTest
class VstupApplicationTests {

	@Autowired
	private EntrantService entrantService;
	@Autowired
	private EnrolledService enrolledService;
	@Autowired
	private FacultyService facultyService;
	@Autowired
	private MarkService markService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private EntrantRepository entrantRepository;
	@Autowired
	private EnrolledRepository enrolledRepository;
	@Autowired
	private FacultyRepository facultyRepository;
	@Autowired
	private MarkRepository markRepository;
	@Autowired
	private SubjectRepository subjectRepository;

	@Test
	public void testSaveEntrant() {
		List<Entrant> entrants = entrantRepository.findAll();
		assertTrue(entrants.size() == 0);
		Entrant entrant = new Entrant();
		entrant.setEmail("1@gmail.com");
		entrant.setFirstName("1");
		entrant.setLastName("1");
		entrant.setPassword("1");
		entrant.setPasswordConfirm("1");

		entrantService.save(entrant);

		entrants = entrantRepository.findAll();
		assertTrue(entrants.size() == 1);

		Entrant entrantFromDb = entrants.get(0);
		assertTrue(entrantFromDb.getEmail().equals(entrant.getEmail()));
		assertTrue(entrantFromDb.getFirstName().equals(entrant.getFirstName()));
		assertTrue(entrantFromDb.getLastName().equals(entrant.getLastName()));
	}

}
