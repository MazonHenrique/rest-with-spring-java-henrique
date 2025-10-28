package br.com.mazonhenrique.repository;

import br.com.mazonhenrique.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}
