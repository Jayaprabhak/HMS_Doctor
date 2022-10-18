import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from '../doctor';
import { Patient } from '../patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  baseUrl:string ="http://localhost:9090/Patient"
  constructor(public http:HttpClient) { }

  storePatient(patient:any):Observable<string> {
    return this.http.post(this.baseUrl+"/spd",patient,{responseType:"text"});
  }
  
  viewstatus(pid:any):Observable <string> {
    return this.http.get(this.baseUrl+"/vpas/"+pid,{responseType:"text"});
  }

  viewDoctor(pid:any):Observable <string> {
    console.log(pid);
    return this.http.get(this.baseUrl+"/vdd/"+pid,{responseType:"text"});
  }
}