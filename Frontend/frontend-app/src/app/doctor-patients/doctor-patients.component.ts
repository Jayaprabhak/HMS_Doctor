import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';
import { Patient } from '../patient';
@Component({
  selector: 'app-doctor-patients',
  templateUrl: './doctor-patients.component.html',
  styleUrls: ['./doctor-patients.component.css']
})
export class DoctorPatientsComponent implements OnInit {
  patients:Array<Patient>=[];
  user : string = ""
  constructor(public ds : DoctorService) { }

  ngOnInit(): void {
    let obj = localStorage.getItem("doctorId");
    if(obj!=null){
      this.user=obj;
    }
    this.findPatient();
  }

  pname:string ="";
  symptoms:string ="";
  mobile:number = 0;
  date:string ="";
  pid:number=0;
  findPatient() {
    this.ds.findPatient(this.user).subscribe({
      next:(result:any)=>this.patients=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    })
  }

  }

