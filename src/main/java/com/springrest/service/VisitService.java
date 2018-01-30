package com.springrest.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import com.springrest.repository.VisitRepository;

@ComponentScan
@Service
@Transactional
public class VisitService {
	
	@Autowired
	VisitRepository visitRepository;

	public VisitService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}
	
}
