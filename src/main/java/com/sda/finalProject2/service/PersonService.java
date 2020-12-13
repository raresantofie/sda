package com.sda.finalProject2.service;

import com.sda.finalProject2.repository.model.Person;

public interface PersonService {

  Person save(Person person);
  Person findById(Long id);

}
