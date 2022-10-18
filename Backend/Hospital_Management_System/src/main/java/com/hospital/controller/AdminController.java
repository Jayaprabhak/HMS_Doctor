package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.bean.Doctor;
import com.hospital.bean.Patient;
import com.hospital.service.AdminService;
import com.hospital.service.DoctorService;

@RestController
@CrossOrigin
@RequestMapping(value="admin")
public class AdminController {
	@Autowired
	AdminService adminserve;
	
	@PostMapping(value = "sdd" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveDoctorDetails(@RequestBody Doctor doctor) {
		return adminserve.saveDoctorDetails(doctor);
	}
	
	@PostMapping(value = "spd" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public String savePatientDetails(@RequestBody Patient patient) {
		return adminserve.savePatientDetails(patient);
	}
	
	@GetMapping(value="vdd",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Doctor> getAllDoctorDetails() {
		return adminserve.viewAllDoctors();
		
	}
	
	@GetMapping(value="vpd",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Patient> getAllPatientDetails() {
		return adminserve.viewAllPatients();
		
	}
	
	@DeleteMapping(value="ddd/{did}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteDoctorDetails(@PathVariable("did") int did) {
		return adminserve.deleteDoctor(did);
	}
	
	@PatchMapping(value="dp/{pid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String dischargePatient(@PathVariable("pid") int pid) {
		return adminserve.dischargePatient(pid);
	}
	
	@PatchMapping(value="ap/{pid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String admitPatient(@PathVariable("pid") int pid) {
		return adminserve.admittedPatient(pid);

	}
	
	@PatchMapping(value="rp/{pid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String rejectPatient(@PathVariable("pid") int pid) {
		return adminserve.rejectPatient(pid);

	}
	
	@PatchMapping(value="ad/{did}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String approveDoctor(@PathVariable("did") int did) {
		return adminserve.approvedDoctor(did);

	}
	
	@PatchMapping(value="rd/{did}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String rejectDoctor(@PathVariable("did") int did) {
		return adminserve.rejectDoctor(did);

	}
	
	@PatchMapping(value="aptp",produces = MediaType.APPLICATION_JSON_VALUE)
	public String appointPatient(@RequestBody Patient patient) {
		return adminserve.appointPatient(patient);
		

	}
	
	@GetMapping(value="vapp",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Patient> viewAllAppointments() {
		return adminserve.viewAllAppointments();
		
	}
	
	@PatchMapping(value="bpa",produces = MediaType.APPLICATION_JSON_VALUE)
	public String bookPatient(@RequestBody Patient patient) {
		return adminserve.bookPatientByadmin(patient);
		

	}


}
