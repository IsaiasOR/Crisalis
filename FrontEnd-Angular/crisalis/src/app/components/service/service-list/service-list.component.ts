import { Component, OnInit } from '@angular/core';
import { ServiceService } from 'src/app/services/service/service.service';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit{
  Services:any;

  constructor(
    private serviceService:ServiceService
  ) {}

  ngOnInit(): void {
    this.serviceService.getService().subscribe(response => {
      console.log(response);
      this.Services=response;
    });
  }

  deleteRegister(id:any, iControl:any) {
    console.log(id);
    console.log(iControl);
    if(window.confirm("¿Desea borrar el registro?")) {
      this.serviceService.deleteService(id).subscribe((response) => {
        this.Services.splice(iControl,1);
      });
      location.reload();
    }
  }

  updateStatus(id:any, iControl:any) {
    this.serviceService.updateStatus(id).subscribe((response) => {
      this.Services.splice(iControl,1);
    });
    location.reload();
  }
}