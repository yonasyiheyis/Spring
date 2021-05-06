package edu.miu.cs.cs544.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.domain.Car;

@Repository
@Transactional(readOnly = true)
public interface CarRepository extends JpaRepository<Car, String>{

}
