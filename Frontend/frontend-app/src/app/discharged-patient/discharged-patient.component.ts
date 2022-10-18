import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';
import { Patient } from '../patient';
@Component({
  selector: 'app-discharged-patient',
  templateUrl: './discharged-patient.component.html',
  styleUrls: ['./discharged-patient.component.css']
})
export class DischargedPatientComponent implements OnInit {
  patients:Array<Patient>=[];
  user : string = ""
  constructor(public ds: DoctorService) { }

  ngOnInit(): void {
    let obj = localStorage.getItem("doctorId");
    if(obj!=null){
      this.user=obj;
    }
    this.findDischargedPatient();
  }
  findDischargedPatient() {
    this.ds.findDischargedPatientById(this.user).subscribe({
      next:(result:any)=>this.patients=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    })
  }
}
