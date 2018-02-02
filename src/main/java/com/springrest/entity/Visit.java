package com.springrest.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="Visit")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "visitId")
public class Visit implements Serializable {
	
	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="Visit_SEQ", sequenceName="Visit_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Visit_SEQ")
	private Integer visitId;
	
	@Column(unique = false, nullable = false, length=20)
	private String description;
	
	@ManyToOne
	@JoinColumn( name = "patientId", nullable = false )
	//@JsonProperty(access = Access.WRITE_ONLY)
	private Patient patient;

	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//@JsonIgnore
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}


}
