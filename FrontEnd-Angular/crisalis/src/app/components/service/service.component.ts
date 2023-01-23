import { Component, OnInit } from '@angular/core';
import { ServiceService } from 'src/app/services/service/service.service';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit{
  Services:any;

  constructor(
    private crudService:ServiceService
  ) {}

  ngOnInit(): void {
    this.crudService.getService().subscribe(response => {
      console.log(response);
      this.Services=response;
    });
  }
}
