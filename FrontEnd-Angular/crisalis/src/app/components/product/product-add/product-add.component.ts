import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ProductService } from 'src/app/services/product/product.service';
import { Router } from '@angular/router';
import { TaxService } from 'src/app/services/tax/tax.service';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})

export class ProductAddComponent implements OnInit {
  formGroup: FormGroup;
  listTaxes: any;

  constructor(
    public form:FormBuilder,
    private productService:ProductService,
    private router:Router,
    private taxService:TaxService
    ) {

    this.formGroup=this.form.group({
      Name:[''],
      BaseAmount:[''],
      Taxes:[]
    });
  }

  ngOnInit(): void {
    this.taxService.getTax().subscribe(response => {
      console.log(response);
      this.listTaxes=response;
    });
  }

  sendData():any {
    console.log(this.formGroup.value);
    
    this.productService.addProduct(this.formGroup.value).subscribe(response => {
      this.router.navigateByUrl('/product-list');
    });
  
  }
}
