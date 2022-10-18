import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';
import { Patient } from '../patient';
@Component({
  selector: 'app-doctorappointments',
  templateUrl: './doctorappointments.component.html',
  styleUrls: ['./doctorappointments.component.css']
})
export class DoctorappointmentsComponent implements OnInit {
  patients:Array<Patient>=[];
  user : string = ""

  constructor(public ds : DoctorService) { }

  ngOnInit(): void {
    let obj = localStorage.getItem("doctorId");
    if(obj!=null){
      this.user=obj;
    }
    this.findAppointment();
  }
  
  pid:number=0;
  pname:string ="";
  symptoms:string ="";
  mobile:number = 0;
  findAppointment() {
    this.ds.findAppointment(this.user).subscribe({
      next:(result:any)=>this.patients=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    })
  }
    deletePatient(patient:any){
      //console.log(pid)
      this.ds.deletePatientById(patient).subscribe({
        next:(result:any)=>console.log(result),
        error:(error:any)=>console.log(error),
        complete:()=>{
          this.findAppointment();   
      }
    })
}
}
