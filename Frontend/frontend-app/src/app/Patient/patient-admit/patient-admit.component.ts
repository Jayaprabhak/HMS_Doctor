import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Patient } from 'src/app/patient';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-patient-admit',
  templateUrl: './patient-admit.component.html',
  styleUrls: ['./patient-admit.component.css']
})
export class PatientAdmitComponent implements OnInit {
  PatientRef = new FormGroup({
   
    pname:new FormControl(),
    pgender:new FormControl(),
    page:new FormControl(),
    paddress:new FormControl(),
    symptoms:new FormControl(),
    emailid:new FormControl(),
    mobile:new FormControl(),
  })
  storeMsg :string =""
  patientRef: any;
  patients:Array<Patient>=[]
  constructor(public ps:PatientService) { }
  

  ngOnInit(): void {
  }
  storePatient() {
    let patient = this.PatientRef.value;
    this.ps.storePatient(patient).subscribe({
      next:(result:any)=>this.storeMsg=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    })

    this.PatientRef.reset();

}

}