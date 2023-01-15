import { Component, OnInit } from '@angular/core';
import { CrudService } from 'src/app/services/service/crud.service';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit{
  Persons:any;

  constructor(
    private crudService:CrudService
  ) {}

  ngOnInit(): void {
    this.crudService.getService().subscribe(response => {
      console.log(response);
    });
  }
}
