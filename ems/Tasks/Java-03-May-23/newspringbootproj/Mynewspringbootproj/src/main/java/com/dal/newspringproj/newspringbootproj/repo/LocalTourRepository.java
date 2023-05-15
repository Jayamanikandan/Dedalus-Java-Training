package com.dal.newspringproj.newspringbootproj.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dal.newspringproj.newspringbootproj.entity.LocalTour;

@Repository
public interface LocalTourRepository extends CrudRepository<LocalTour, Long>{

}
