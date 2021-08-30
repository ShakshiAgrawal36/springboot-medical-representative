package com.example.demo.service;

import java.util.List;

import com.example.demo.model.MedicalRepresentative;




public interface MedicalRepresentativeService {
	MedicalRepresentative saveMedicalRepresentative(MedicalRepresentative medicalRepresentative);
	List<MedicalRepresentative> getAllMRs();
	MedicalRepresentative getMRByMrId(long mrId);
	MedicalRepresentative updateMR(MedicalRepresentative medicalRepresentative, long mrId);
	void deleteMR(long mrId);
}
