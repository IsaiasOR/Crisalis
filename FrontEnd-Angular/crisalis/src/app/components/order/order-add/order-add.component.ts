import { Component } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { OrderService } from 'src/app/services/order/order.service';
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
    private crudService:OrderService,
    private router:Router
    ) {

    this.formGroup=this.form.group({
      DateCreated:[''],
      Amount:[''],
      Description:[''],
      Products:[''],
      Services:[''],
      Clients:[''],
      User:['']
    });
  }

  sendData():any {
    console.log("Me presionaste");
    console.log(this.formGroup.value);
    
    this.crudService.addOrder(this.formGroup.value).subscribe();
  
    this.router.navigateByUrl('/order');
  }
}
