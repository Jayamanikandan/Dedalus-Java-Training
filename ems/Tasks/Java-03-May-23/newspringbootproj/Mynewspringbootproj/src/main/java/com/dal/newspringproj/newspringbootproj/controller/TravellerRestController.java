package com.dal.newspringproj.newspringbootproj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dal.newspringproj.newspringbootproj.entity.ForeignTour;
import com.dal.newspringproj.newspringbootproj.entity.LocalTour;
import com.dal.newspringproj.newspringbootproj.entity.Traveller;
import com.dal.newspringproj.newspringbootproj.repo.TravellerRepository;
import com.dal.newspringproj.newspringbootproj.service.TravellerService;

@RestController
public class TravellerRestController {

	@Autowired
	TravellerService travellerService;
	
	@Autowired
	TravellerRepository travellerRepository;
	
	@GetMapping("/welcome")
	public String helloAppln() {
		return "Hi welcome Traveller";
	}
	
	@PostMapping("/addtraveller")	
	public Traveller addTraveller(@RequestBody Traveller traveller) {
		return travellerService.addTraveller(traveller);
	}
	
	
	@PostMapping("/requestlocaltour")
	public LocalTour saveLocalTourRequest(@RequestBody LocalTour localTour) {
		return travellerService.saveLocalTourRequest(localTour);
	}

	
	@PostMapping("/requestforeigntour")
	
	public ForeignTour saveForeignTourRequest(@RequestBody ForeignTour foreignTour) {
		System.out.println("****** From Controller Foreign ******" + foreignTour);
		return travellerService.saveForeignTourRequest(foreignTour);
	}
	
	@GetMapping("/listtravellers")
	public List<Traveller> listAllTravellers() {

		return travellerService.listAllTravellers();
	}
	
	@GetMapping("/findbytid/{tid}")
	public Optional<Traveller> searchByTravllerId(@PathVariable Long tid)
	{
		return travellerService.searchByTravllerId(tid);
	}
	
	@GetMapping("/findbytname/{tname}")
	public Traveller searchByTravllerName(@PathVariable String tname)
	{
		return travellerService.searchByTravllerName(tname);
	}
	
	@DeleteMapping("/deleteById/{tid}")
	public void DeleteTravellerById(@PathVariable Long tid)
	{
		 travellerService.DeleteTravellerById(tid);
	}
}
	


