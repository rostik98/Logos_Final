package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.domain.Enrolled;

public interface EnrolledRepository extends JpaRepository<Enrolled, Integer> {

}
