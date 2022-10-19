package com.hospital.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospital.bean.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	@Query("select d from Doctor d where d.did = :dpid")
	public Optional <Doctor> getDoctorById(@Param("dpid") Integer dpid);
	
	@Query("select d from Doctor d where d.emailid = :email and d.dstatus = 'approved'")
	public Optional <Doctor> getDoctorId(@Param("email")String email);
	
	@Query("select d from Doctor d where d.emailid = :email and d.dstatus = 'approved'")
    public Optional <Doctor> checkEmail(@Param("email") String email);

}
