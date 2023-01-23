import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, EmailValidator } from '@angular/forms';
import { PersonService } from 'src/app/services/person/person.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-person-add',
  templateUrl: './person-add.component.html',
  styleUrls: ['./person-add.component.css']
})
export class PersonAddComponent {
  formGroup: FormGroup;

  constructor(
    public form:FormBuilder,
    private crudService:PersonService,
    private router:Router
    ) {

    this.formGroup=this.form.group({
      firstname:[''],
      lastname:[''],
      dni:[''],
      email:[''],
      phoneNumber:[''],
      direction:[''],
      cuit:['']
    });
  }

  sendData():any {
    console.log("Me presionaste");
    console.log(this.formGroup.value);
    
    this.crudService.addPerson(this.formGroup.value).subscribe();
  
    this.router.navigateByUrl('/person');
  }
}
