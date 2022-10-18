package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.bean.Doctor;
import com.hospital.bean.Patient;
import com.hospital.repo.PatientRepository;
import com.hospital.service.PatientService;

@RestController
@CrossOrigin
@RequestMapping(value="Patient")
public class PatientController {
	@Autowired
	PatientService patserve;
	
	@PostMapping(value = "spd" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public String savePatientDetails(@RequestBody Patient patient) {
		return patserve.savePatientDetails(patient);
	}
	
	@GetMapping(value="vdd/{pid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String getDoctorDetails(@PathVariable("pid") int pid) {
		System.out.println(pid);
		return patserve.getDoctorDetails(pid);
	}
	
	@GetMapping(value="vpas/{pid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String viewPatientAppointmentStatus(@PathVariable("pid") int pid) {
		return patserve.viewAppointmentStatus(pid);
	}

}
