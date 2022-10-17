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
    let obj = sessionStorage.getItem("doctorId");
    if(obj!=null){
      this.user=obj;
    }
  }

  name:string ="";
  symptoms:string ="";
  mobile:number = 0;
  findPatient() {
    this.ds.findPatient(this.user).subscribe({
      next:(result:any)=>this.patients=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    })
  }
    deletePatient(patients:any){
      //console.log(pid)
      this.ds.deletePatientById(this.patients).subscribe({
        next:(result:any)=>console.log(result),
        error:(error:any)=>console.log(error),
        complete:()=>{
          this.findPatient();   
      }
    })
  }

  }

