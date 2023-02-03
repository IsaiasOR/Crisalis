import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { OrderService } from 'src/app/services/order/order.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/services/product/product.service';
import { ServiceService } from 'src/app/services/service/service.service';
import { PersonService } from 'src/app/services/person/person.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-order-edity',
  templateUrl: './order-edity.component.html',
  styleUrls: ['./order-edity.component.css']
})
export class OrderEdityComponent implements OnInit {
  formOrder: FormGroup;
  id:any;
  listProducts: any;
  listServices: any;
  listClients: any;
  listUsers: any;

  constructor(
    private activeRote:ActivatedRoute,
    private orderService:OrderService,
    public formBuilder:FormBuilder,
    private router:Router,
    private productService:ProductService,
    private serviceService:ServiceService,
    private personService:PersonService,
    private userService:UserService
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);

    this.orderService.getSingleOrder(this.id).subscribe(
      response => {
        console.log(response);
        this.formOrder.setValue({
          Description:response['description'],
          Products:response['products'],
          Services:response['services'],
          Client:response['client'],
          User:response['user']
        });
      }
    );

    this.formOrder = this.formBuilder.group({
      Description:[],
      Products:[],
      Services:[''],
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
    console.log(this.id);
    console.log(this.formOrder.value);

    this.orderService.editOrder(this.id, this.formOrder.value).subscribe(() => {
      this.router.navigateByUrl('/order-list');
    });
  }
}