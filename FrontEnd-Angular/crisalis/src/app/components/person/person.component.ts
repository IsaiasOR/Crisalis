import { Component, OnInit } from '@angular/core';
import { PersonService } from 'src/app/services/person/person.service';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit{
  Persons:any;

  constructor(
    private crudService:PersonService
  ) {}

  ngOnInit(): void {
    this.crudService.getPerson().subscribe(response => {
      console.log(response);
      this.Persons=response;
    });
  }
}
