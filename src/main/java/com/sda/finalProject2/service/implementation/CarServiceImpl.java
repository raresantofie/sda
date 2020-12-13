package com.sda.finalProject2.service.implementation;

import com.sda.finalProject2.repository.CarRepository;
import com.sda.finalProject2.repository.model.Car;
import com.sda.finalProject2.service.CarService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

  private CarRepository carRepository;

  public CarServiceImpl(@Autowired CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @Override
  public Car save(Car car) {
    return carRepository.save(car);
  }

  @Override
  public Car findById(Long id) {
    Optional<Car> car = carRepository.findById(id);
    if (car.isPresent()) {
      return car.get();
    } else {
      throw new RuntimeException(String.format("Car with id = %d not found", id));
    }
  }
}
