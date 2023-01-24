import { Component, OnInit } from '@angular/core';
import { BusinessService } from 'src/app/services/business/business.service';

@Component({
  selector: 'app-business',
  templateUrl: './business.component.html',
  styleUrls: ['./business.component.css']
})
export class BusinessComponent implements OnInit{
  Business:any;

  constructor(private crudService:BusinessService) {}

  ngOnInit(): void {
    this.crudService.getBusiness().subscribe(response => {
      console.log(response);
      this.Business=response;
    });
  }

  deleteRegister(id:any, iControl:any) {
    console.log(id);
    console.log(iControl);
  }
}
