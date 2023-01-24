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
    private personService:PersonService
  ) {}

  ngOnInit(): void {
    this.personService.getPerson().subscribe(response => {
      console.log(response);
      this.Persons=response;
    });
  }

  deleteRegister(id:any, iControl:any) {
    console.log(id);
    console.log(iControl);
    if(window.confirm("¿Desea borrar el registro?")) {
      this.personService.deletePerson(id).subscribe((response) => {
        this.Persons.splice(iControl,1);
      });
    }
  }
}
