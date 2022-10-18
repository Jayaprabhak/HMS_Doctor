import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-get-docid',
  templateUrl: './get-docid.component.html',
  styleUrls: ['./get-docid.component.css']
})
export class GetDocidComponent implements OnInit {
  user:string="";
  msg:string="";
  constructor() { }

  ngOnInit(): void {
  }
  storeid(){
    if(this.user.length>0) {
     this.msg="Id Saved"
    }else {
      this.msg="Invalid Id"
    }
    localStorage.setItem("doctorId",this.user);
  }
}
