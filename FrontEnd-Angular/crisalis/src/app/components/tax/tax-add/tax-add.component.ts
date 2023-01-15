import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, EmailValidator } from '@angular/forms';
import { CrudService } from 'src/app/services/tax/crud.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tax-add',
  templateUrl: './tax-add.component.html',
  styleUrls: ['./tax-add.component.css']
})
export class TaxAddComponent {
  formGroup: FormGroup;

  constructor(
    public form:FormBuilder,
    private crudService:CrudService,
    private router:Router
    ) {

    this.formGroup=this.form.group({
      name:[''],
      amount:['']
    });
  }

  sendData():any {
    console.log("Me presionaste");
    console.log(this.formGroup.value);
    
    this.crudService.addTax(this.formGroup.value).subscribe();
  
    this.router.navigateByUrl('/tax');
  }
}