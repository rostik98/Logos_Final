package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.domain.Mark;

public interface MarkRepository extends JpaRepository<Mark, Integer> {

}
