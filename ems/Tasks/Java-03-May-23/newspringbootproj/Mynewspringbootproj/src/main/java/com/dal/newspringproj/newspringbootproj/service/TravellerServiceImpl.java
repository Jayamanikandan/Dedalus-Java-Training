package com.dal.newspringproj.newspringbootproj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dal.newspringproj.newspringbootproj.entity.ForeignTour;
import com.dal.newspringproj.newspringbootproj.entity.LocalTour;
import com.dal.newspringproj.newspringbootproj.entity.Traveller;
import com.dal.newspringproj.newspringbootproj.repo.ForeignTourRepository;
import com.dal.newspringproj.newspringbootproj.repo.LocalTourRepository;
import com.dal.newspringproj.newspringbootproj.repo.TravellerRepository;


@Service
public class TravellerServiceImpl implements TravellerService{

	@Autowired
	private TravellerRepository travellerRepository;
	
	@Autowired
	private LocalTourRepository localTourRepository;
	
	@Autowired
	private ForeignTourRepository foreignTourRepository;
	
	@Override
	public Traveller addTraveller(Traveller traveller) {
		
		return travellerRepository.save(traveller);
	}


	

	@Override
	public LocalTour saveLocalTourRequest(LocalTour localTour) {
		Traveller traveller = localTour.getTrtourist();
		localTour.setTrtourist(traveller);
		return localTourRepository.save(localTour);
	}

	@Override
	public ForeignTour saveForeignTourRequest(ForeignTour foreignTour) {
		System.out.println("-----------foreign Tour -------" +foreignTour);
		Traveller traveller = foreignTour.getTrtourist();
		foreignTour.setTrtourist(traveller);
		return foreignTourRepository.save(foreignTour);
	}




	@Override
	public List<Traveller> listAllTravellers() {
		
		 return (List<Traveller>) travellerRepository.findAll();
	}




	@Override
	public Optional<Traveller> searchByTravllerId(Long tid) {
		// TODO Auto-generated method stub
		return travellerRepository.findById(tid);
	}




	@Override
	public Traveller searchByTravllerName(String tname) {
		// TODO Auto-generated method stub
		return travellerRepository.findByTravellerName(tname);
	}




	@Override
	public void  DeleteTravellerById(Long tid) {
		// TODO Auto-generated method stub
		 travellerRepository.deleteById(tid);;
	}

	
	
	

	
}
