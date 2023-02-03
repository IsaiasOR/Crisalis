import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { PersonService } from 'src/app/services/person/person.service';
import { Router } from '@angular/router';
import { BusinessService } from 'src/app/services/business/business.service';

@Component({
  selector: 'app-person-add',
  templateUrl: './person-add.component.html',
  styleUrls: ['./person-add.component.css']
})
export class PersonAddComponent implements OnInit {
  formGroup: FormGroup;
  listBusiness:any;

  constructor(
    public form:FormBuilder,
    private crudService:PersonService,
    private router:Router,
    private businessService:BusinessService
    ) {

    this.formGroup=this.form.group({
      FirstName:[''],
      LastName:[''],
      DNI:[''],
      Email:[''],
      PhoneNumber:[''],
      Address:[''],
      Business:[''],
      ActiveService:['false']
    });
  }

  ngOnInit(): void {
    this.businessService.getBusiness().subscribe(response => {
      console.log(response);
      this.listBusiness=response;
    });
  }

  sendData():any {
    console.log(this.formGroup.value);
    
    this.crudService.addPerson(this.formGroup.value).subscribe(response => {
      this.router.navigateByUrl('/person-list');
    });
  
  }
}
