import { Component, OnInit } from '@angular/core';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-patient-appointment',
  templateUrl: './patient-appointment.component.html',
  styleUrls: ['./patient-appointment.component.css']
})
export class PatientAppointmentComponent implements OnInit {
  user : string = ""
  status : string = ""

  constructor(public ps: PatientService) { }

  ngOnInit(): void {
    let obj = localStorage.getItem("patId");
    if(obj!=null){
      this.user=obj;
    }
  }
  viewstatus() {
    this.ps.viewstatus(this.user).subscribe({
      next:(result:any)=>this.status=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    })
}
}
