import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-view-id',
  templateUrl: './view-id.component.html',
  styleUrls: ['./view-id.component.css']
})
export class ViewIdComponent implements OnInit {
  email:string =""
  constructor(public ds :DoctorService) { }
  msg:string = ""
  ngOnInit(): void {
  }
  viewid(email:string){
    this.ds.viewid(email).subscribe({
        next:(result:any)=>{
          if(result>0) {
            this.msg=result;
          }else {
            this.msg="Application Pending";
          }
        },
        error:(error:any)=>console.log(error),
        complete:()=>console.log("completed")
           
         
    })
  }
}
