package com.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.bean.Doctor;
import com.hospital.bean.Login;
import com.hospital.bean.Patient;
import com.hospital.repo.DoctorRepository;
import com.hospital.repo.LoginRepository;
import com.hospital.repo.PatientRepository;

@Service
public class DoctorService {
	@Autowired
	DoctorRepository docrepo;
	@Autowired
	PatientRepository patrepo;
	@Autowired
	LoginRepository loginrepo;
	
	public String saveDoctorDetails(Doctor doctor) {
		docrepo.save(doctor);
		return "doctor details saved successfully";
	}
	
	public List<Patient> viewPatient(int did) {
		List<Patient> result = patrepo.findByDpid(did);
		return result;
	}
	
	public List<Patient> viewAppointment(int did) {
		return patrepo.getappoinmentsByid(did);
	}
	
	public String deleteAppointment(Patient patient) {
	     Optional<Patient> result  = patrepo.findById(patient.getPid());
	       if(result.isPresent()) {
		      Patient p = result.get();
		      p.setPstatus("consulted");
		      patrepo.saveAndFlush(p);
		      return "patient record deleted";
	
	       }else {
		     return "patient not found";
	       }
	}
	
	public List<Patient> dischargePatientByid(int did) {
		return patrepo.dischargePatientByid(did);
	}
	
	public int findDoctorId(String email){
		Optional <Doctor> result = docrepo.getDoctorId(email);
		if(result.isPresent()) {
			Doctor d = result.get();
			return d.getDid();
		}else {
			return 0;
		}
	}
	public String signIn(Login login) {
		Optional<Login> result = loginrepo.findById(login.getEmailid());
		if(result.isPresent()) {
					Login ll = result.get();
					if(ll.getPassword().equals(login.getPassword())) {		
						if(login.getRole().equals(ll.getRole()) && login.getRole().equals("doctor")) {
							return "Doctor sucessfully login";
						}else if(login.getRole().equals(ll.getRole()) && login.getRole().equals("patient")){
							return "Patient successfully login";
						}else {
							return "No data found with these details";
						}					
					}else {
						return "Incorrect Password";
					}
		}else {
			return "Incorrect Id";
		}	
	}
	

	
	public String signUp(Login login) {
		Optional<Login> result = loginrepo.findById(login.getEmailid());
		if(result.isPresent()) {
					return "This id is already registered";
		}else {
		if(login.getRole().equals("doctor")) {
            if(docrepo.checkEmail(login.getEmailid()).isPresent()) {
            	loginrepo.save(login);
				return "Account created successfully";
				
            }else {
            	return "Invalid Credentials";
            }
		}else {
			if(patrepo.checkEmail(login.getEmailid()).isPresent()) {
            	loginrepo.save(login);
				return "Account created successfully";
				
            }else {
            	return "Invalid Credentials";
            }
			
		}	
		
	}
	
}
}