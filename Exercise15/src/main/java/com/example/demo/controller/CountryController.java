package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CountryRepository;
import com.example.demo.domain.Country;

@RestController
@RequestMapping("/countries")
public class CountryController {
	
	private CountryRepository repo;

	public CountryRepository getRepo() {
		return repo;
	}

	@Autowired
	public void setRepo(CountryRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public List<Country> listCountries(){
		return repo.findAll();
	}

}
