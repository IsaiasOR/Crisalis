import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, EmailValidator } from '@angular/forms';
import { CrudService } from 'src/app/service/business/crud.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-business-add',
  templateUrl: './business-add.component.html',
  styleUrls: ['./business-add.component.css']
})
export class BusinessAddComponent {
  formGroup: FormGroup;

  constructor(
    public form:FormBuilder,
    private crudService:CrudService,
    private router:Router
    ) {

    this.formGroup=this.form.group({
      businessName:[''],
      startDateAct:[''],
      cuit:[''],
      dni:['']
    });
  }

  sendData():any {
    console.log("Me presionaste");
    console.log(this.formGroup.value);
    
    this.crudService.addBusiness(this.formGroup.value).subscribe();
  
    this.router.navigateByUrl('/business');
  }
}
