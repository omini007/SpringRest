package com.springrest.controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.entity.Patient;
import com.springrest.entity.Visit;
import com.springrest.repository.PatientRepository;
import com.springrest.repository.VisitRepository;

@RestController
public class Controller {
	
	public static final String ANNOTATION_DATA = "annotationData"; 
	private static final String ANNOTATIONS = "annotations";
	
	@Autowired
	PatientRepository patientRepository;

	@Autowired
	VisitRepository visitRepository;

	// Method to add a new course
	@PostMapping("patient/add")
	public ResponseEntity<Void> newPatient( @RequestBody Patient newPatient ){

		System.out.println("Patient Add : " + newPatient.toString());
		Patient patient = new Patient();
		patient = patientRepository.save(newPatient);
		System.out.println("Patient Added : " + patient.toString());

		if ( patient == null )
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("visit/add")
	public ResponseEntity<Void> newVisit( @RequestBody Visit newVisit ){

		System.out.println("Visit Add : " + newVisit.toString());
		Visit visit = new Visit();
		visit = visitRepository.save(newVisit);
		System.out.println("Visit Added : " + visit.toString());

		if ( visit == null )
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}


	// Method to get all Patients
	@GetMapping("/patients/all")
	@Transactional
	public List<Patient> getAllPatients( ){

		System.out.println("In Get All Patients Service");
		List<Patient> list = patientRepository.findAll();
		for (Patient patient : list)
		{
			patient.toString();
		}
		
		return list;
	}

	// Method to get all Patients
	@GetMapping("/visits/all")
	@Transactional
	public List<Visit> getAllVisits( ){

		System.out.println("In Get All Visit Service");
		List<Visit> list = visitRepository.findAll();
		for (Visit visit : list)
		{
			visit.getPatient().toString();
		}
		
		return list;
	}
	
	@GetMapping("/visits/{visitId}")
	@Transactional
	public int getAllPatientId(@PathVariable int visitId ){

		System.out.println("In Get All Visit Service");
		int i = visitRepository.getAllPatientId(visitId);
		return i;
	}
	
	@GetMapping("/visits/p/{patientId}")
	@Transactional
	public List<Visit> getAllVisitsByPatientId(@PathVariable int patientId ){

		System.out.println("In Get All Visit Service");
		List<Visit> list = visitRepository.getAllVisits(patientId);
		for (Visit v : list)
		{
			System.out.println("I : " + v.toString());
		}
		return list;
	}
}
