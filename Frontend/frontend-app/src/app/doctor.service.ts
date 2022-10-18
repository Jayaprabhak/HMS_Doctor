import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './patient';
import { Doctor } from './doctor';
@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  baseUrl:string ="http://localhost:9090/Doctor";
  constructor(public http:HttpClient) { 
    
  }
  viewid (email:string):Observable <Doctor[]> {
      return this.http.get<Doctor[]>(this.baseUrl+ "/gdid/"+email);
    }
    
  applyjob(doctor:any):Observable<string> {
      return this.http.post(this.baseUrl+"/sdd",doctor,{responseType:"text"});
    }
  findPatient(did:any):Observable<Patient[]> {
      return this.http.get<Patient[]>(this.baseUrl+"/vap/"+did);
  }
  deletePatientById(patient:any):Observable <string> {
    return this.http.patch(this.baseUrl+"/ups",patient,{responseType:"text"});
  }
  findAppointment(did:any):Observable<Patient[]> {
    return this.http.get<Patient[]>(this.baseUrl+"/vaa/"+did);
  }
  findDischargedPatientById(did:any):Observable <Patient[]> {
    return this.http.get<Patient[]>(this.baseUrl+"/vpd/"+did);
  }
  signIn(login:any):Observable<string>{
    return this.http.post(this.baseUrl+"/signIn", login,{responseType:"text"});
  }

  signUp(login:any):Observable<string>{
    return this.http.post(this.baseUrl+"/signUp", login,{responseType:"text"});
  }
  }

