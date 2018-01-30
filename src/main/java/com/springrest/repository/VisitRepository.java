package com.springrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springrest.entity.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer>{

	@Query( value = "select v.patient.patientId from Visit v where v.visitId=:visitId" )
	public int getAllPatientId(@Param("visitId") int visitId);
	
	@Query( value = "from Visit v where v.patient.patientId=:patientId" )
	public List<Visit> getAllVisits(@Param("patientId") int patientId);
}
