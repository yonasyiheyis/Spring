package edu.miu.cs.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.Car;
import edu.miu.cs.cs544.repository.CarRepository;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private CarRepository carRepository;
	
	@GetMapping
	public List<Car> findAll() {
		return carRepository.findAll();
	}
	
	@GetMapping(params = "paged=true")
	public Page<Car> findAll(Pageable pageable) {
		return carRepository.findAll(pageable);
	}
	
}
