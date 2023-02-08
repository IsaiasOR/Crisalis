import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/services/product/product.service';
import { ServiceService } from 'src/app/services/service/service.service';
import { TaxService } from 'src/app/services/tax/tax.service';
import { OrderDetailsService } from 'src/app/services/order-details/order-details.service';

@Component({
  selector: 'app-order-details-add',
  templateUrl: './order-details-add.component.html',
  styleUrls: ['./order-details-add.component.css']
})
export class OrderDetailsAddComponent implements OnInit {
  formGroup: FormGroup;
  listProducts: any;
  listServices: any;
  listTaxes: any;
  formNumber: number = 0;

  constructor(
    public form:FormBuilder,
    private orderDetailsService:OrderDetailsService,
    private router:Router,
    private productService:ProductService,
    private serviceService:ServiceService,
    private taxService:TaxService
    ) {

    this.formGroup=this.form.group({
      Description:[''],
      Product:[],
      Quantity:[],
      Guarantee:[],
      Service:[],
      Taxes:[]
    });
  }

  ngOnInit(): void {
    this.productService.getProductComplete().subscribe(response => {
      console.log(response);
      this.listProducts=response;
    });

    this.serviceService.getServiceComplete().subscribe(response => {
      console.log(response);
      this.listServices=response;
    });

    this.taxService.getTax().subscribe(response => {
      console.log(response);
      this.listTaxes=response;
    });
  }

  sendData():any {
    console.log(this.formGroup.value);
    
    this.orderDetailsService.addOrderDetails(this.formGroup.value).subscribe(reponse => {
      this.router.navigateByUrl('/order-add');
    });
  }
}