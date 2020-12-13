package com.sda.finalProject2.controller;

import com.sda.finalProject2.repository.model.Person;
import com.sda.finalProject2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

  private PersonService personService;

  public PersonController(@Autowired PersonService personService) {
    this.personService = personService;
  }

  /**
   *
   * ----Filtru deserializare----
   * {
   *     "name" : "Elon Musk",
   *     "cars": [
   *         {
   *             "type": "Testla",
   *             "color": "White"
   *         }
   *     ]
   * }
   *
   *
   *  --- serializare ---
   *
   *  Cyclic dependecy;
   *  Person :
   *   {
   *     "name" : "Elon musk",
   *    "cars" : [
   *        {
   *          "type" : "tesla",
   *          "color" : "white",
   *          "person" : {
   *            "name": "Elon Musk",
   *            "cars" : [
   *               {
   *    *          "type" : "tesla",
   *    *          "color" : "white",
   *    *          "person" : {
   *    *            "name": "Elon Musk",
   *    *            "cars" : [
   *    *
   *    *            ]
   *    *          }
   *    *        }
   *            ]
   *          }
   *        }
   *    ]
   *   }
   * @param person
   * @return
   */
  @PostMapping(value = "/persons")
  public Person save(@RequestBody Person person) {
    return personService.save(person);
  }
}
