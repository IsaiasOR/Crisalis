import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { OrderService } from 'src/app/services/order/order.service';
import { Router, ActivatedRoute } from '@angular/router';
import { PersonService } from 'src/app/services/person/person.service';
import { UserService } from 'src/app/services/user/user.service';
import { OrderDetailsService } from 'src/app/services/order-details/order-details.service';

@Component({
  selector: 'app-order-edity',
  templateUrl: './order-edity.component.html',
  styleUrls: ['./order-edity.component.css']
})
export class OrderEdityComponent implements OnInit {
  formOrder: FormGroup;
  id:any;
  listClients: any;
  listUsers: any;
  listOrdersDetails: any;

  constructor(
    public formBuilder:FormBuilder,
    private orderService:OrderService,
    private router:Router,
    private personService:PersonService,
    private userService:UserService,
    private orderDetailsService:OrderDetailsService,
    private activatedRoute:ActivatedRoute
  ) {
    this.id = this.activatedRoute.snapshot.paramMap.get('Id');
    console.log(this.id);

    this.orderService.findOrder(this.id).subscribe(
      response => {
        console.log(response);
        this.formOrder.setValue({
          TotalAmount:response['totalAmount'],
          Description:response['description'],
          Client:response['client'],
          User:response['user'],
          OrderDetails:response['orderDetails']
        });
      }
    );

    this.formOrder = this.formBuilder.group({
      TotalAmount:[],
      Description:[''],
      Client:[''],
      User:[''],
      OrderDetails:[]
    });

  }

  ngOnInit(): void {
    this.orderService.findOrder(this.id).subscribe(response => {
      console.log(response);
      this.listOrdersDetails=response.orderDetails;
      this.formOrder=this.formBuilder.group({
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
    console.log(this.id);
    console.log(this.formOrder.value);

    this.orderService.editOrder(this.id, this.formOrder.value).subscribe(() => {
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