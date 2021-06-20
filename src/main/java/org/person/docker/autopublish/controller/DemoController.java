package org.person.docker.autopublish.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.person.docker.autopublish.dto.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("car")
@Validated
@Slf4j
public class DemoController {

  @GetMapping("{carId}")
  public ResponseEntity<Car> getCar(@PathVariable Integer carId) {
    log.info("DemoController::Get car with id = {}", carId);
    return new ResponseEntity<>(new Car("name1", "v1"), HttpStatus.OK);
  }

  @PutMapping("{carId}")
  public ResponseEntity<Car> updateCar(@PathVariable Integer carId, @Valid @NotNull @RequestBody Car car) {
    log.info("DemoController::Update car with id = {}", carId);
    return new ResponseEntity<>(car, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Car> createCar(@Valid @NotNull @RequestBody Car car) {
    log.info("DemoController::Create car");
    return new ResponseEntity<>(car, HttpStatus.CREATED);
  }

  @DeleteMapping("{carId}")
  public ResponseEntity<?> deleteCar(@PathVariable Integer carId) {
    log.info("DemoController::delete car with id = {}", carId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }


}
