package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MedicalRepresentative;
import com.example.demo.service.MedicalRepresentativeService;

@RestController
@RequestMapping("/api/mr")
public class MedicalRepresentativeController {

	private MedicalRepresentativeService medicalRepresentativeService;

	public MedicalRepresentativeController(MedicalRepresentativeService medicalRepresentativeService) {
		super();
		this.medicalRepresentativeService = medicalRepresentativeService;
	}
	
	//build create REST API
	@PostMapping
	public ResponseEntity<MedicalRepresentative> saveMedicalRepresentative(@RequestBody MedicalRepresentative medicalRepresentative){
		
		return new ResponseEntity<MedicalRepresentative>(medicalRepresentativeService.saveMedicalRepresentative(medicalRepresentative), HttpStatus.CREATED);
	}
	
	//build get all MR REST API
	@GetMapping
	public List<MedicalRepresentative> getgetAllMRs(){
		return medicalRepresentativeService.getAllMRs();
	}
	
	//build get MR by ID REST API
	//http://localhost:8080/api/mr/101
	@GetMapping("{mrId}")
	public ResponseEntity<MedicalRepresentative> getMRByMrId(@PathVariable("mrId") long mrId){
		return new ResponseEntity<MedicalRepresentative>(medicalRepresentativeService.getMRByMrId(mrId), HttpStatus.OK);
	}
	
	//build update MR REST API
	//http://localhost:8080/api/mr/101
	@PutMapping("{mrId}")
	public ResponseEntity<MedicalRepresentative> updateMR(@PathVariable("mrId") long mrId, @RequestBody MedicalRepresentative medicalRepresentative){
			return new ResponseEntity<MedicalRepresentative>(medicalRepresentativeService.updateMR(medicalRepresentative, mrId), HttpStatus.OK);
		}
	
	//delete MR REST API
	//http://localhost:8080/api/mr/101
	@DeleteMapping("{mrId}")
	public ResponseEntity<String> deleteMR(@PathVariable("mrId") long mrId){
		medicalRepresentativeService.deleteMR(mrId);
		return new ResponseEntity<String>("MR deleted Sucessfully", HttpStatus.OK);
	}
}
