package ua.lviv.lgs.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.EntrantRepository;
import ua.lviv.lgs.domain.Entrant;

@Service
public class EntrantService {
	private Logger logger = LoggerFactory.getLogger(EntrantService.class);

	@Autowired
	private EntrantRepository entrantRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(Entrant entrant) {
		logger.info("Create new entrant " + entrant);
		entrant.setPassword(bCryptPasswordEncoder.encode(entrant.getPassword()));
		entrant.setPasswordConfirm(bCryptPasswordEncoder.encode(entrant.getPasswordConfirm()));
		entrantRepository.save(entrant);
	}

	public Entrant getOneByEmail(String email) {
		logger.info("Get entrant by email " + email);
		Optional<Entrant> byEmail = entrantRepository.findByEmail(email);
		return byEmail.get();
	}

	public List<Entrant> getAllEntrants() {
		logger.info("Get all entrants");
		return entrantRepository.findAll();
	}
}
