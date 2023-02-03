import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { PersonService } from 'src/app/services/person/person.service';
import { BusinessService } from 'src/app/services/business/business.service';

@Component({
  selector: 'app-person-edity',
  templateUrl: './person-edity.component.html',
  styleUrls: ['./person-edity.component.css']
})
export class PersonEdityComponent implements OnInit {
  formPerson: FormGroup;
  id:any;
  listBusiness:any;

  constructor(
    private activeRote:ActivatedRoute,
    private personService:PersonService,
    public formBuilder:FormBuilder,
    private router:Router,
    private businessService:BusinessService
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);

    this.personService.getSinglePerson(this.id).subscribe(
      response => {
        console.log(response);
        this.formPerson.setValue({
          FirstName:response['FirstName'],
          LastName:response['LastName'],
          DNI:response['DNI'],
          Email:response['Email'],
          PhoneNumber:response['PhoneNumber'],
          Address:response['Address'],
          Business:['Business'],
          ActiveService:response['ActiveService']
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
      ActiveService:[''],
      Business:['']
    });

  }

  ngOnInit(): void {
    this.businessService.getBusiness().subscribe(response => {
      console.log(response);
      this.listBusiness=response;
    });
  }

  sendData():any {
    console.log(this.id);
    console.log(this.formPerson.value);
    this.personService.editPerson(this.id, this.formPerson.value).subscribe(() => {
      this.router.navigateByUrl('/person-list');
    });
  }
}