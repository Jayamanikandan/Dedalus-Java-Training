package com.dal.newspringproj.newspringbootproj.service;

import java.util.List;

import com.dal.newspringproj.newspringbootproj.entity.ForeignTour;
import com.dal.newspringproj.newspringbootproj.entity.LocalTour;
import com.dal.newspringproj.newspringbootproj.entity.Traveller;

public interface TravellerService {
	public Traveller addTraveller(Traveller traveller);
	public LocalTour saveLocalTourRequest(LocalTour localTour);
	public ForeignTour saveForeignTourRequest(ForeignTour foreignTour);
	public List<Traveller> listAllTravellers();
}
