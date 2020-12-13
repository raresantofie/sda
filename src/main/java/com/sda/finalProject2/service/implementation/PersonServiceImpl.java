package com.sda.finalProject2.service.implementation;

import com.sda.finalProject2.repository.PersonRepository;
import com.sda.finalProject2.repository.model.Person;
import com.sda.finalProject2.service.PersonService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  @Value("company")
  private String company;

  private PersonRepository personRepository;

  public PersonServiceImpl(@Autowired PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public Person save(Person person) {
    person.setName(person.getName() + " - " + company);
    return personRepository.save(person);
  }

  @Override
  public Person findById(Long id) {
    Optional<Person> person = personRepository.findById(id);
    if (person.isPresent()) {
      return person.get();
    } else {
      throw new RuntimeException(String.format("User with id = %d not found", id));
    }
  }
}
