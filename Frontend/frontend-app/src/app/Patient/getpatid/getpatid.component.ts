import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-getpatid',
  templateUrl: './getpatid.component.html',
  styleUrls: ['./getpatid.component.css']
})
export class GetpatidComponent implements OnInit {
  user:string="";
  constructor() { }

  ngOnInit(): void {
  }
  storeid(){
    console.log(this.user);
    localStorage.setItem("patId",this.user);
  }
}
