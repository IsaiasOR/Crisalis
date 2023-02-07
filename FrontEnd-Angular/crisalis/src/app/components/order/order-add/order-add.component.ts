import { Component, OnInit, ɵɵsetComponentScope } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { OrderService } from 'src/app/services/order/order.service';
import { Router } from '@angular/router';
import { PersonService } from 'src/app/services/person/person.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-order-add',
  templateUrl: './order-add.component.html',
  styleUrls: ['./order-add.component.css']
})

export class OrderAddComponent implements OnInit {
  formGroup: FormGroup;
  listClients: any;
  listUsers: any;

  constructor(
    public form:FormBuilder,
    private crudService:OrderService,
    private router:Router,
    private personService:PersonService,
    private userService:UserService
    ) {

    this.formGroup=this.form.group({
      Description:[''],
      Client:[''],
      User:['']
    });
  }

  ngOnInit(): void {
    // this.productService.getProductComplete().subscribe(response => {
    //   console.log(response);
    //   this.listProducts=response;
    // });

    // this.serviceService.getServiceComplete().subscribe(response => {
    //   console.log(response);
    //   this.listServices=response;
    // });

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
    
    this.crudService.addOrder(this.formGroup.value).subscribe(response => {
      this.router.navigateByUrl('/order-list');
    });
  }
}
