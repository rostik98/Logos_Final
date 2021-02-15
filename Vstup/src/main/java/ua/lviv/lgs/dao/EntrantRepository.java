package ua.lviv.lgs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.domain.Entrant;

public interface EntrantRepository extends JpaRepository<Entrant, Integer> {
	Optional<Entrant> findByEmail(String email);
}
