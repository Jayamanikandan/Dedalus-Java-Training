package com.dal.newspringproj.newspringbootproj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dal.newspringproj.newspringbootproj.entity.ForeignTour;

@Repository
	public interface ForeignTourRepository extends JpaRepository<ForeignTour, Long>{

	}

