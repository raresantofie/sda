package com.sda.finalProject2;

import com.sda.finalProject2.repository.PersonRepository;
import com.sda.finalProject2.repository.model.Car;
import com.sda.finalProject2.repository.model.Person;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

  @Autowired
  private PersonRepository personRepository;

  @Test
  public void testPersonIsCreated() {
    Set<Car> carSet = new HashSet<>();
    Car tesla = new Car("Tesla", "Black");
    Car ford = new Car("Ford", "White");
    carSet.add(tesla);
    carSet.add(ford);

    Person person = new Person();
    person.setName("Elon Musk");
    person.setCars(carSet);
    Person db = personRepository.save(person);
    Assert.notNull(db.getId());
  }
}
