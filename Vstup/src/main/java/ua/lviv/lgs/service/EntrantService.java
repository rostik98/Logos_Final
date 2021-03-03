package ua.lviv.lgs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.EntrantRepository;
import ua.lviv.lgs.domain.Entrant;

@Service
public class EntrantService {
	@Autowired
	private EntrantRepository entrantRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(Entrant entrant) {
		entrant.setPassword(bCryptPasswordEncoder.encode(entrant.getPassword()));
		entrant.setPasswordConfirm(bCryptPasswordEncoder.encode(entrant.getPasswordConfirm()));
		entrantRepository.save(entrant);
	}

	public Entrant getOneByEmail(String email) {
		Optional<Entrant> byEmail = entrantRepository.findByEmail(email);
		return byEmail.get();
	}

	public List<Entrant> getAllEntrants() {
		return entrantRepository.findAll();
	}
}
