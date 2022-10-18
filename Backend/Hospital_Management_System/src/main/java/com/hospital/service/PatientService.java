package com.hospital.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.bean.Doctor;
import com.hospital.bean.Patient;
import com.hospital.repo.DoctorRepository;
import com.hospital.repo.PatientRepository;

@Service
public class PatientService {
	@Autowired
	PatientRepository patrepo;
	DoctorRepository docrepo;
	
	public String savePatientDetails(Patient patient) {
		patrepo.save(patient);
		return "patient details saved successfully";
	}
	
	public String getDoctorDetails(int pid) {
		Optional<Patient> result = patrepo.findById(pid);
		if(result.isPresent()) {
			Patient p = result.get();
			System.out.println(p);
			Optional <Doctor> d = docrepo.getDoctorById(p.getDpid());
			System.out.println(d);
			 if(d.isPresent()) {
				return result.get().toString();
			 }else {
				 return "doctor details not found";
			 }
		}else {
			return "patient record not found";
		}
		
	}
	
	
	
	public String viewAppointmentStatus(int pid) {
		Optional<Patient> result = patrepo.findById(pid);
		if(result.isPresent()) {
			Patient p = result.get();
			return p.getPstatus();
		}else {
			return "patient record not found";
		}
	}
	
	
	
	
	
	
	
	

}
