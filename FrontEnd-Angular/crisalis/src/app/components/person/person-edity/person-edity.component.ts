import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { PersonService } from 'src/app/services/person/person.service';

@Component({
  selector: 'app-person-edity',
  templateUrl: './person-edity.component.html',
  styleUrls: ['./person-edity.component.css']
})
export class PersonEdityComponent implements OnInit {
  formPerson: FormGroup;
  id:any;

  constructor(
    private activeRote:ActivatedRoute,
    private personService:PersonService,
    public formBuilder:FormBuilder,
    private router:Router
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);

    this.personService.getSinglePerson(this.id).subscribe(
      response => {
        console.log(response);
        this.formPerson.setValue({
          FirstName:response[0]['FirstName'],
          LastName:response[0]['LastName'],
          DNI:response[0]['DNI'],
          Email:response[0]['Email'],
          PhoneNumber:response[0]['PhoneNumber'],
          Address:response[0]['Address'],
          ActiveService:response[0]['ActiveService']
        });
      }
    );

    this.formPerson = this.formBuilder.group({
      FirstName:[''],
      LastName:[''],
      DNI:[''],
      Email:[''],
      PhoneNumber:[''],
      Address:[''],
      ActiveService:['']
    });

  }

  ngOnInit(): void {
  }

  sendData():any {
    console.log(this.id);
    console.log(this.formPerson.value);
    this.personService.editPerson(this.id, this.formPerson.value).subscribe(() => {
      this.router.navigateByUrl('/person-list');
    });
  }
}