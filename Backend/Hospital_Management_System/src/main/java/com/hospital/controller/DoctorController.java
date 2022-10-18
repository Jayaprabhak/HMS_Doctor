package com.hospital.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.bean.Doctor;
import com.hospital.bean.Login;
import com.hospital.bean.Patient;
import com.hospital.service.DoctorService;

@RestController
@RequestMapping(value ="Doctor")
@CrossOrigin
public class DoctorController {
	@Autowired
	DoctorService docserve;
	@GetMapping(value="vap/{did}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Patient> getAllPatients(@PathVariable("did") int did) {
		return docserve.viewPatient(did);
	}
	
	@GetMapping(value="vaa/{did}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Patient> getAllAppoinments(@PathVariable("did") int did) {
		return docserve.viewAppointment(did);
	}
	@PostMapping(value = "sdd" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveDoctorDetails(@RequestBody Doctor doctor) {
		return docserve.saveDoctorDetails(doctor);
	}
	 
	@PatchMapping(value = "ups",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updatePatient(@RequestBody Patient patient) {
		return docserve.deleteAppointment(patient);
	}
	
	@GetMapping(value="vpd/{did}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Patient> getAllDischarged(@PathVariable("did") int did) {
		return docserve.dischargePatientByid(did);
	}
	
	@GetMapping(value="gdid/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
	public int findDoctorId(@PathVariable("email") String email) {
		return docserve.findDoctorId(email);
	}
	@PostMapping(value = "signIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody Login login) {
		 System.out.println(login);
		return docserve.signIn(login);
	}
	
	@PostMapping(value = "signUp", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody Login login) {
		return docserve.signUp(login);
	}
	
}
