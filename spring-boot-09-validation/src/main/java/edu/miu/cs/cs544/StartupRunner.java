package edu.miu.cs.cs544;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import edu.miu.cs.cs544.domain.Customer;
import edu.miu.cs.cs544.repository.CustomerRepository;

@Component
public class StartupRunner implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository repo;
	
    @Override
    @Transactional
    public void run(String...args) throws Exception {
//    	Country c1 = new Country("US", "United States", LocalDate.now());
//    	Country c2 = new Country("CA", "Canada", LocalDate.now());
//    	Country c3 = new Country("MX", "Mexico", LocalDate.now());
//    	countryRepository.save(c1);
//    	countryRepository.save(c2);
//    	countryRepository.save(c3);
    	
    	Date myDate = parseDate("2014-02-14");
    	Date myDate3 = parseDate("2024-02-14");
    	
    	Customer c1 = new Customer("Yonas", "Yiheyis", myDate, "yy@gmail.com");
    	Customer c2 = new Customer("John", "Doe", myDate, "jd@gmail.com");
    	Customer c3 = new Customer("Jane", "Mary", myDate3, "jm@gmail.com");
    	
    	repo.save(c1);
    	repo.save(c2);
    	repo.save(c3);
    	
    }
    
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
     }
    
}
