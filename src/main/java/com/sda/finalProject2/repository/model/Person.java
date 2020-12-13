package com.sda.finalProject2.repository.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "persons")
public class Person {

  @Id
  @GeneratedValue
  private Long id;

  private transient String name;

  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
  private Set<Car> cars;

  public Person(String name, Set<Car> cars) {
    this.cars = cars;
    this.name = name;
  }

  public Person() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<Car> getCars() {
    return cars;
  }

  /**
   *
   *  In faza initiala metoda arata asa :
   *  public void setCars(Set<Car> cars) {
   *     this.cars = cars;
   *   }
   *
   * Inainte de salvare noi ne cream un obiect de tip Person
   * care avea un nume x, si un set de masini de tipul [ {id: generated, type: string, color: string, person: null}
   *  => TransientException
   *
   *
   *  Implementarea corecta :
   *
   *  public void setCars(Set<Car> cars) {
   *     this.cars = cars;
   *     for(Car car : cars) {
   *       car.setPerson(this);
   *     }
   *   }
   *
   */
  public void setCars(Set<Car> cars) {
    this.cars = cars;
    for(Car car : cars) {
      car.setPerson(this);
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
