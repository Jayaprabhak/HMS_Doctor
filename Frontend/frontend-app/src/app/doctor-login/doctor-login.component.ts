import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { DoctorService } from '../doctor.service';
@Component({
  selector: 'app-doctor-login',
  templateUrl: './doctor-login.component.html',
  styleUrls: ['./doctor-login.component.css']
})
export class DoctorLoginComponent implements OnInit {
  msg:string = "";
  loginRef= new FormGroup({
    emailid:new FormControl(),
    password:new FormControl(),
    role:new FormControl()
  });
  constructor(public router:Router, public ds:DoctorService) { }

  ngOnInit(): void {
  }
  signInNow(){
    let login = this.loginRef.value;
    this.ds.signIn(login).subscribe({
      next:(result:any)=>{
        if(result == "Doctor sucessfully login"){
          this.msg = "Doctor sucessfully login";
        //  localStorage.setItem("doctorId",login.id);
          this.router.navigate(["/doctor"])
        }
        else if(result == "Patient successfully login"){
          this.msg = "Patient successfully login";
        //  localStorage.setItem("patId",login.id);
          this.router.navigate(["/patient"])
        }else{
          this.msg = result;
        }
      },
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed..")
    });

  }
}
