import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { OrderService } from 'src/app/services/order/order.service';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/services/product/product.service';
import { ServiceService } from 'src/app/services/service/service.service';
import { PersonService } from 'src/app/services/person/person.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-order-add',
  templateUrl: './order-add.component.html',
  styleUrls: ['./order-add.component.css']
})

export class OrderAddComponent implements OnInit{
  formGroup: FormGroup;
  listProducts: any;
  listServices: any;
  listClients: any;
  listUsers: any;

  constructor(
    public form:FormBuilder,
    private crudService:OrderService,
    private router:Router,
    private productService:ProductService,
    private serviceService:ServiceService,
    private personService:PersonService,
    private userService:UserService
    ) {

    this.formGroup=this.form.group({
      Description:[''],
      Products:[],
      Services:[],
      Client:[''],
      User:['']
    });
  }

  ngOnInit(): void {
    this.productService.getProduct().subscribe(response => {
      console.log(response);
      this.listProducts=response;
    });

    this.serviceService.getService().subscribe(response => {
      console.log(response);
      this.listServices=response;
    });

    this.personService.getPerson().subscribe(response => {
      console.log(response);
      this.listClients=response;
    });

    this.userService.getUser().subscribe(response => {
      console.log(response);
      this.listUsers=response;
    });
  }

  sendData():any {
    console.log("Me presionaste");
    console.log(this.formGroup.value);
    
    this.crudService.addOrder(this.formGroup.value).subscribe(response => {
      this.router.navigateByUrl('/order-list');
    });
  }
}
