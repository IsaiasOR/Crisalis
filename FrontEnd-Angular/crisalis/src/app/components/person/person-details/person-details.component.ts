import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PersonService } from 'src/app/services/person/person.service';

@Component({
  selector: 'app-person-details',
  templateUrl: './person-details.component.html',
  styleUrls: ['./person-details.component.css']
})
export class PersonDetailsComponent implements OnInit {
  id:any;
  personDetails:any;

  constructor(
    private activeRote:ActivatedRoute,
    private personService:PersonService,
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);
  }

  ngOnInit(): void {
    this.personService.getSinglePerson(this.id).subscribe(response => {
      console.log(response);
      this.personDetails=response;
    });
  }
}