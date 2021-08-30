package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="medical_representative")
public class MedicalRepresentative {
	public MedicalRepresentative() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="mr_id")
	private long mrId;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="drug")
	private String drug;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMrId() {
		return mrId;
	}

	public void setMrId(long mrId) {
		this.mrId = mrId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDrug() {
		return drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public MedicalRepresentative(long id, long mrId, String name, String drug) {
		super();
		this.id = id;
		this.mrId = mrId;
		this.name = name;
		this.drug = drug;
	}

	@Override
	public String toString() {
		return "MedicalRepresentative [id=" + id + ", mrId=" + mrId + ", name=" + name + ", drug=" + drug + "]";
	}


		
}
