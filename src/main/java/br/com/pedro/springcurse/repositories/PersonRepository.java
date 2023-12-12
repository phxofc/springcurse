package br.com.pedro.springcurse.repositories;

import br.com.pedro.springcurse.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PersonRepository extends JpaRepository<Person, Long> {
}
