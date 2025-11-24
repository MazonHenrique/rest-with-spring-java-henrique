package br.com.mazonhenrique.services;

import br.com.mazonhenrique.exception.ResourceNotFoundException;
import br.com.mazonhenrique.model.Person;
import br.com.mazonhenrique.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        logger.info("Finding all People");
        return repository.findAll();
    }

    public Person findById(Long id){
        logger.info("Finding one Person!");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }

    public Person create(Person person){
        logger.info("Creating one person");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one person");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());

        repository.save(entity);
        return entity;
    }

    public void delete(Long id){
        logger.info("Deleting one person");
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }
}
