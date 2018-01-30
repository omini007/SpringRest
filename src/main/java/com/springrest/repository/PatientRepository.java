package com.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springrest.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
