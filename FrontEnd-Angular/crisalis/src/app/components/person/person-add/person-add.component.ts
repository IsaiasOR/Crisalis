import { Component } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
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
      FirstName:[''],
      LastName:[''],
      DNI:[''],
      Email:[''],
      PhoneNumber:[''],
      Address:[''],
      ActiveService:['false']
    });
  }

  sendData():any {
    console.log(this.formGroup.value);
    
    this.crudService.addPerson(this.formGroup.value).subscribe(response => {
      this.router.navigateByUrl('/person-list');
    });
  
  }
}
