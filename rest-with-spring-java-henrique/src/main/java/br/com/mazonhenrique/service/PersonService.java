package br.com.mazonhenrique.service;

import br.com.mazonhenrique.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all People");

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id){
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Henrique");
        person.setLastName("Mazon");
        person.setAdress("Lauro Muller");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person){
        logger.info("Creating one person");
        return person;
    }

    public Person update(Person person){
        logger.info("Updating one person");
        return person;
    }

    public void delete(String id){
        logger.info("Deleting one person");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Pessoa " + i);
        person.setLastName("Sobrenome " + i);
        person.setAdress("Endereco " + i);
        person.setGender("Genero " + i);
        return person;
    }


}
