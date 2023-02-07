import { Component, OnInit, ɵɵsetComponentScope } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { OrderService } from 'src/app/services/order/order.service';
import { Router } from '@angular/router';
import { PersonService } from 'src/app/services/person/person.service';
import { UserService } from 'src/app/services/user/user.service';
import { OrderDetailsService } from 'src/app/services/order-details/order-details.service';

@Component({
  selector: 'app-order-add',
  templateUrl: './order-add.component.html',
  styleUrls: ['./order-add.component.css']
})

export class OrderAddComponent implements OnInit {
  formGroup: FormGroup;
  listClients: any;
  listUsers: any;
  listOrdersDetails: any;

  constructor(
    public form:FormBuilder,
    private orderService:OrderService,
    private router:Router,
    private personService:PersonService,
    private userService:UserService,
    private orderDetailsService:OrderDetailsService
    ) {

    this.formGroup=this.form.group({
      TotalAmount:[],
      Description:[''],
      Client:[''],
      User:[''],
      OrderDetails:[]
    });
  }

  ngOnInit(): void {
    this.orderDetailsService.getOrderDetailsNoOrder().subscribe(response => {
      console.log(response);
      this.listOrdersDetails=response;
      this.formGroup=this.form.group({
        TotalAmount:[],
        Description:[''],
        Client:[''],
        User:[''],
        OrderDetails:[this.listOrdersDetails]
      });
    });

    this.personService.getPersonComplete().subscribe(response => {
      console.log(response);
      this.listClients=response;
    });

    this.userService.getUserComplete().subscribe(response => {
      console.log(response);
      this.listUsers=response;
    });
  }

  sendData():any {
    console.log(this.formGroup.value);
    
    this.orderService.addOrder(this.formGroup.value).subscribe(response => {
      this.router.navigateByUrl('/order-list');
    });
  }

  deleteRegister(id:any) {
    console.log(id);
    if(window.confirm("¿Desea borrar el registro?")) {
      this.orderDetailsService.deleteOrderDetails(id).subscribe();
      location.reload();
    }
  }
}
