package br.com.pedro.springcurse.repositories;

import br.com.pedro.springcurse.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> { }
