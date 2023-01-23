import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, EmailValidator } from '@angular/forms';
import { BusinessService } from 'src/app/services/business/business.service';
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
    private crudService:BusinessService,
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
