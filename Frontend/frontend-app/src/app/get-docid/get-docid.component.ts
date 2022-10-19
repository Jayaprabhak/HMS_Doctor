import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-get-docid',
  templateUrl: './get-docid.component.html',
  styleUrls: ['./get-docid.component.css']
})
export class GetDocidComponent implements OnInit {
  user:string="";
  constructor() { }

  ngOnInit(): void {
  }
  storeid(){
    console.log(this.user);
    localStorage.setItem("doctorId",this.user);
  }
}
