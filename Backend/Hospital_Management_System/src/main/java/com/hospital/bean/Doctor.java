package com.hospital.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	private String dname;
	private String specialization;
	private String phno;
	private String emailid;
	private String address;
	@Column(columnDefinition = "varchar(25) default 'onhold'")
	private String dstatus;
	private int dage;
	private String dgender;
	@OneToMany
	@JoinColumn(name="dpid")
	private List<Patient> listOfpat;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDstatus() {
		return dstatus;
	}
	public void setDstatus(String dstatus) {
		this.dstatus = dstatus;
	}
	public int getDage() {
		return dage;
	}
	public void setDage(int dage) {
		this.dage = dage;
	}
	public String getDgender() {
		return dgender;
	}
	public void setDgender(String dgender) {
		this.dgender = dgender;
	}
	public List<Patient> getListOfpat() {
		return listOfpat;
	}
	public void setListOfpat(List<Patient> listOfpat) {
		this.listOfpat = listOfpat;
	}
	@Override
	public String toString() {
		return "Doctor [did=" + did + ", dname=" + dname + ", specialization=" + specialization + ", phno=" + phno
				+ ", emailid=" + emailid + ", address=" + address + ", dstatus=" + dstatus + ", dage=" + dage
				+ ", dgender=" + dgender + ", listOfpat=" + listOfpat + "]";
	}
	
	
	
	
}
	