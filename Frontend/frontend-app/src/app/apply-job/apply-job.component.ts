import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup} from '@angular/forms'
import { DoctorService } from '../doctor.service';
@Component({
  selector: 'app-apply-job',
  templateUrl: './apply-job.component.html',
  styleUrls: ['./apply-job.component.css']
})
export class ApplyJobComponent implements OnInit {
  doctorRef = new FormGroup({
    dname:new FormControl(),
    dage:new FormControl(),
    phno:new FormControl(),
    dgender:new FormControl(),
    emailid:new FormControl(),
    daddress:new FormControl(),
    specialization: new FormControl()
  })
  storeMsg : string = ""
  constructor(public ds:DoctorService) { }

  ngOnInit(): void {
  }
  applyjob() {
    let doctor = this.doctorRef.value;
    this.ds.applyjob(doctor).subscribe({
      next:(result:any)=>this.storeMsg=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    })
}
}
