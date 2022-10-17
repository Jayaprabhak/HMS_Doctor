import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './patient';
@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  baseUrl:string ="http://localhost:9090/Doctor";
  constructor(public http:HttpClient) { 
    
  }
  getdid (did:number):Observable <string> {
      return this.http.get(this.baseUrl+ "/gdid/"+did,{responseType:"text"});
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
  }

