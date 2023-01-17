import { Component, OnInit } from '@angular/core';
import { CrudService } from 'src/app/services/business/crud.service';

@Component({
  selector: 'app-business',
  templateUrl: './business.component.html',
  styleUrls: ['./business.component.css']
})
export class BusinessComponent implements OnInit{
  Business:any;

  constructor(
    private crudService:CrudService
  ) {}

  ngOnInit(): void {
    this.crudService.getBusiness().subscribe(response => {
      console.log(response);
      this.Business=response;
    });
  }
}
