import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { DoctorService } from '../doctor.service';
@Component({
  selector: 'app-doctor-signup',
  templateUrl: './doctor-signup.component.html',
  styleUrls: ['./doctor-signup.component.css']
})
export class DoctorSignupComponent implements OnInit {
  msg:string = "";
  loginRef= new FormGroup({
    emailid:new FormControl(),
    password:new FormControl(),
    role:new FormControl()
  });
  constructor(public ds:DoctorService) { }

  ngOnInit(): void {
  }
  signUp(){
    let login = this.loginRef.value;
    this.ds.signUp(login).subscribe({
      next:(result:any)=>this.msg=result,
      error:(error:any)=>this.msg=error,
      complete:()=>console.log("completed")
    });
  }
}
