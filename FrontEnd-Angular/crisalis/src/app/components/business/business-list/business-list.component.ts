import { Component, OnInit } from '@angular/core';
import { BusinessService } from 'src/app/services/business/business.service';

@Component({
  selector: 'app-business-list',
  templateUrl: './business-list.component.html',
  styleUrls: ['./business-list.component.css']
})
export class BusinessListComponent implements OnInit {
  Businesses:any;

  constructor(
    private businessService:BusinessService
  ) {}

  ngOnInit(): void {
    this.businessService.getBusiness().subscribe(response => {
      console.log(response);
      this.Businesses=response;
    });
  }

  deleteRegister(id:any, iControl:any) {
    console.log(id);
    console.log(iControl);
    if(window.confirm("¿Desea borrar el registro?")) {
      this.businessService.deleteBusiness(id).subscribe((response) => {
        this.Businesses.splice(iControl,1);
      });
      location.reload();
    }
  }
}
