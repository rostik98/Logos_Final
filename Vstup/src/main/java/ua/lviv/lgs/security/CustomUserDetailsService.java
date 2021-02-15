package ua.lviv.lgs.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.EntrantRepository;
import ua.lviv.lgs.domain.Entrant;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private EntrantRepository entrantRepository;
	// private EntrantRolesRepository entrantRolesRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<Entrant> entrantOptional = entrantRepository.findByEmail(email);
		if (entrantOptional.isPresent()) {
			return new CustomUserDetails(entrantOptional.get());
		}

		throw new UsernameNotFoundException("No entrant with email: " + email);

	}
}
