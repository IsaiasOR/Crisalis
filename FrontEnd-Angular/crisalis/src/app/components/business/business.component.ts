import { Component, OnInit } from '@angular/core';
import { BusinessService } from 'src/app/services/business/business.service';

@Component({
  selector: 'app-business',
  templateUrl: './business.component.html',
  styleUrls: ['./business.component.css']
})

export class BusinessComponent implements OnInit{
  Business:any;

  constructor(private businessService:BusinessService) {}

  ngOnInit(): void {
    this.businessService.getBusiness().subscribe(response => {
      console.log(response);
      this.Business=response;
    });
  }

  deleteRegister(id:any, iControl:any) {
    console.log(id);
    console.log(iControl);
    if(window.confirm("¿Desea borrar el registro?")) {
      this.businessService.deleteBusiness(id).subscribe((response) => {
        this.Business.splice(iControl,1);
      });
    }
  }
}
