package com.sda.finalProject2.repository;

import com.sda.finalProject2.repository.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
