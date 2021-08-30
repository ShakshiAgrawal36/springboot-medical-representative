package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.MedicalRepresentative;
import com.example.demo.repository.MedicalRepresentativeRepository;
import com.example.demo.service.MedicalRepresentativeService;

@Service
public class MedicalRepresentativeImpl implements MedicalRepresentativeService{

	private MedicalRepresentativeRepository medicalRepresentativeRepository;
	
	public MedicalRepresentativeImpl(MedicalRepresentativeRepository medicalRepresentativeRepository) {
		super();
		this.medicalRepresentativeRepository = medicalRepresentativeRepository;
	}

	@Override
	public MedicalRepresentative saveMedicalRepresentative(MedicalRepresentative medicalRepresentative) {
		return medicalRepresentativeRepository.save(medicalRepresentative);
	}

	@Override
	public List<MedicalRepresentative> getAllMRs() {
		return medicalRepresentativeRepository.findAll();
	}

	@Override
	public MedicalRepresentative getMRByMrId(long mrId) {
		// TODO Auto-generated method stub
		return medicalRepresentativeRepository.findById(mrId).orElseThrow(()-> new ResourceNotFoundException("MedicalRepresentative", "mrId", mrId));
	}

	@Override
	public MedicalRepresentative updateMR(MedicalRepresentative medicalRepresentative, long mrId) {
		MedicalRepresentative existingMR = medicalRepresentativeRepository.findById(mrId).orElseThrow(
				() -> new ResourceNotFoundException("MedicalRepresentative", "id", mrId));
		
		existingMR.setDrug(medicalRepresentative.getDrug());
		existingMR.setMrId(medicalRepresentative.getMrId());
		//existingMR.setId(medicalRepresentative.getId());
		existingMR.setName(medicalRepresentative.getName());
		
		medicalRepresentativeRepository.save(existingMR);
		return null;
	}

	@Override
	public void deleteMR(long mrId) {
		medicalRepresentativeRepository.findById(mrId).orElseThrow(
				() -> new ResourceNotFoundException("MedicalRepresentative", "mrId", mrId));
		medicalRepresentativeRepository.deleteById(mrId);
		
	}

}
