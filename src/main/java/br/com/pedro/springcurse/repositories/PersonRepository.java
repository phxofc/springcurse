package br.com.pedro.springcurse.repositories;

import br.com.pedro.springcurse.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {
}
