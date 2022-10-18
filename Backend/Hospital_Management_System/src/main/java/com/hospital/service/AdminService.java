package com.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.bean.Doctor;
import com.hospital.bean.Patient;
import com.hospital.repo.DoctorRepository;
import com.hospital.repo.PatientRepository;

@Service
public class AdminService {
	@Autowired
	PatientRepository patrepo;
	DoctorRepository docrepo;
	
	public String saveDoctorDetails(Doctor doctor) {
		docrepo.save(doctor);
		return "doctor details saved successfully";
	}
	
	public String savePatientDetails(Patient patient) {
		patrepo.save(patient);
		return "patient details saved successfully";
	}
	
	public List<Doctor> viewAllDoctors() {
		return docrepo.findAll();
	}
	
	public List<Patient> viewAllPatients() {
		return patrepo.findAll();
	}
	public String deleteDoctor(int did) {
		Optional<Doctor> result = docrepo.findById(did);
		if(result.isPresent()) {
			Doctor d = result.get();
			docrepo.delete(d);
		return " Doctor record is deleted";
		}else {
			return "Doctor record not found";
		}
	}
	public String dischargePatient(int pid ) {
		Optional<Patient> result = patrepo.findById(pid);
		if(result.isPresent()) {
			Patient p = result.get();
			p.setPstatus("discharged");
			patrepo.saveAndFlush(p);
			
		return "patient is discharged";
		}else {
			return "patient record not found";
		}
	}
	
	
	
	public String admittedPatient(int pid) {
		Optional<Patient> result = patrepo.findById(pid);
		if(result.isPresent()) {
			Patient p =result.get();
			p.setPstatus("admitted");
			patrepo.saveAndFlush(p);
			return "patient admitted is successful";
			
		}else {
			return "patient record not found";
			
		}
	}
	
	public String rejectPatient(int pid) {
		Optional<Patient> result = patrepo.findById(pid);
		if(result.isPresent()) {
			Patient p =result.get();
			p.setPstatus("rejected");
			patrepo.saveAndFlush(p);
			return "patient appointment is rejected";
			
		}else {
			return "patient record not found";
			
		}
	}
	
	public String approvedDoctor(int did) {
		Optional<Doctor> result = docrepo.findById(did);
		if(result.isPresent()) {
			Doctor d =result.get();
			d.setDstatus("approved");
			docrepo.saveAndFlush(d);
			return "Doctor application is approved successfully";
			
		}else {
			return "Doctor record not found";
			
		}
	}
	
	public String rejectDoctor(int did) {
		Optional<Doctor> result = docrepo.findById(did);
		if(result.isPresent()) {
			Doctor d =result.get();
			d.setDstatus("rejected");
			docrepo.saveAndFlush(d);
			return "Doctor application is rejected";
			
		}else {
			return "Doctor record not found";
			
		}
	}
	
	public String appointPatient(Patient patient) {
		Optional<Patient> result = patrepo.findById(patient.getPid());
		if(result.isPresent()) {
			Patient p =result.get();
			p.setDpid(patient.getDpid());
			p.setPstatus("appointed");
			patrepo.saveAndFlush(p);
			return "patient appointed is successfully";
			
		}else {
			return "patient record not found";
			
		}
	}
	
	
	public List<Patient> viewAllAppointments() {
		return patrepo.viewAllAppointments();
		
	}
	
	public String bookPatientByadmin(Patient patient) {
		Optional<Patient> result = patrepo.findById(patient.getPid());
		if(result.isPresent()) {
			Patient p =result.get();
			p.setDpid(patient.getDpid());
			p.setPstatus("appointed");
			patrepo.saveAndFlush(p);
			return "patient appointed is successfully";
			
		}else {
			return "patient record not found";
			
		}
	}

}
