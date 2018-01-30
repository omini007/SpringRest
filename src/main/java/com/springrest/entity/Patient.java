package com.springrest.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="Patient")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "patientId")
public class Patient implements Serializable{
	
	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="Patient_SEQ", sequenceName="Patient_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Patient_SEQ")
	private Integer patientId;
	
	@Column(unique = false, nullable = false, length=20)
	private String name;
	
	@OneToMany( mappedBy = "patient" , cascade = CascadeType.ALL)
	//@JsonBackReference
	private List<Visit> visits;

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//@JsonIgnore
	public List<Visit> getVisits() {
		return visits;
	}
	@Override
	public String toString() {
		if( visits != null )
			this.visits.size();
		return "Patient [patientId=" + patientId + ", name=" + name + ", visits=" + visits + "]";
	}
	
}
