import { Component, OnInit } from '@angular/core';
import { CrudService } from 'src/app/service/crud.service';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent {
  Persons:any;

  constructor(
    private crudService:CrudService
  ) {}

  ngOnInit(): void {
    this.crudService.getPerson().subscribe(response => {
      console.log(response);
    });
  }
}
