import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { CrudService } from 'src/app/services/order/crud.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order-add',
  templateUrl: './order-add.component.html',
  styleUrls: ['./order-add.component.css']
})
export class OrderAddComponent {
  formGroup: FormGroup;

  constructor(
    public form:FormBuilder,
    private crudService:CrudService,
    private router:Router
    ) {

    this.formGroup=this.form.group({
      dateCreated:[''],
      amount:[''],
      description:[''],
      products:[''],
      services:[''],
      client:[''],
      taxes:[''],
      user:['']
    });
  }

  sendData():any {
    console.log("Me presionaste");
    console.log(this.formGroup.value);
    
    this.crudService.addOrder(this.formGroup.value).subscribe();
  
    this.router.navigateByUrl('/order');
  }
}
