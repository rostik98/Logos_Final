package ua.lviv.lgs;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.EnrolledRepository;
import ua.lviv.lgs.dao.EntrantRepository;
import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.dao.MarkRepository;
import ua.lviv.lgs.dao.SubjectRepository;
import ua.lviv.lgs.domain.Enrolled;
import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Mark;
import ua.lviv.lgs.domain.Subject;
import ua.lviv.lgs.service.EnrolledService;
import ua.lviv.lgs.service.EntrantService;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.MarkService;
import ua.lviv.lgs.service.SubjectService;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan("ua.lviv.lgs")
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

	@Test
	public void testFindByEmail() {
		List<Entrant> entrants = entrantRepository.findAll();
		assertTrue(entrants.size() == 0);
		Entrant entrant = new Entrant();
		entrant.setEmail("1@gmail.com");
		entrant.setFirstName("1");
		entrant.setLastName("1");
		entrant.setPassword("1");
		entrant.setPasswordConfirm("1");

		entrantRepository.save(entrant);

		Entrant findByEmail = entrantService.getOneByEmail(entrant.getEmail());

		assertTrue(findByEmail.getEmail().equals(entrant.getEmail()));
	}

	@Test
	public void testGetAllEntrants() {
		Entrant entrant = new Entrant();
		entrant.setEmail("1@gmail.com");
		entrant.setFirstName("1");
		entrant.setLastName("1");
		entrant.setPassword("1");
		entrant.setPasswordConfirm("1");

		entrantRepository.save(entrant);

		Entrant entrant1 = new Entrant();
		entrant1.setEmail("2@gmail.com");
		entrant1.setFirstName("2");
		entrant1.setLastName("2");
		entrant1.setPassword("2");
		entrant1.setPasswordConfirm("2");

		entrantRepository.save(entrant1);
		List<Entrant> entrants = entrantRepository.findAll();
		assertTrue(entrants.size() == 2);
	}

	@Test
	public void testSubject() {
		List<Subject> subjects = subjectRepository.findAll();
		assertTrue(subjects.size() == 0);

		Subject subject = new Subject();
		subject.setName("Physic");

		subjectRepository.save(subject);

		subjects = subjectService.getAllSubjects();
		assertTrue(subjects.size() == 1);
		Subject findById = subjectService.findById(subjects.get(0).getId());
		assertTrue(findById.getName() == "Physic");

	}

	@Test
	public void testMark() {
		Entrant entrant = new Entrant();
		entrant.setEmail("1@gmail.com");
		entrant.setFirstName("1");
		entrant.setLastName("1");
		entrant.setPassword("1");
		entrant.setPasswordConfirm("1");
		Mark mark = new Mark();
		mark.setValue(100);
		mark.setEntrant(entrant);
		Subject subject = new Subject();
		subject.setName("Physic");
		mark.setSubject(subject);
		subjectRepository.save(subject);
		entrantRepository.save(entrant);
		markRepository.save(mark);
		assertTrue(markService.getAllMarks().get(0).getEntrant().getPassword().equals("1"));
		assertTrue(markService.getAllMarks().get(0).getSubject().getName().equals("Physic"));
	}

	@Test
	public void testFaculty() {
		Faculty faculty = new Faculty();
		faculty.setId(1);
		faculty.setName("QWERTY");
		faculty.setBudgetPlaces(10);
		faculty.setPassingScore(5.);
		facultyRepository.save(faculty);

		assertTrue(facultyService.findByName("QWERTY").getPassingScore() == 5.);
	}

	@Test
	public void testEnrolled() {
		Entrant entrant = new Entrant();
		entrant.setEmail("1@gmail.com");
		entrant.setFirstName("1");
		entrant.setLastName("1");
		entrant.setPassword("1");
		entrant.setPasswordConfirm("1");

		entrantRepository.save(entrant);

		Mark mark = new Mark();
		mark.setValue(100);
		mark.setEntrant(entrant);
		Subject subject = new Subject();
		subject.setName("Physic");
		subjectRepository.save(subject);
		mark.setSubject(subject);
		markRepository.save(mark);

		Mark mark1 = new Mark();
		mark1.setValue(150);
		mark1.setEntrant(entrant);
		Subject subject1 = new Subject();
		subject1.setName("Physic1");
		subjectRepository.save(subject1);
		mark1.setSubject(subject1);
		markRepository.save(mark1);

		Faculty faculty = new Faculty();
		faculty.setId(1);
		faculty.setName("QWERTY");
		faculty.setBudgetPlaces(10);
		faculty.setPassingScore(180.);

		facultyRepository.save(faculty);

		Enrolled enrolled = new Enrolled();
		enrolled.setFacultyId(faculty);
		enrolled.setEntrantId(entrant);
		enrolled.setCompetitiveScore((mark.getValue() + mark1.getValue()) / 2.);
		if (enrolled.getFacultyId().getPassingScore() <= enrolled.getCompetitiveScore()) {
			enrolledService.save(enrolled);
		}
		assertTrue(enrolledRepository.findAll().size() == 0);
	}
}
