package com.sda.finalProject2.service;

import com.sda.finalProject2.repository.model.Car;

public interface CarService {

  Car save(Car car);
  Car findById(Long id);

}
