import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ProductService } from 'src/app/services/product/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})

export class ProductAddComponent implements OnInit {
  formGroup: FormGroup;

  constructor(
    public form:FormBuilder,
    private productService:ProductService,
    private router:Router,
    ) {

    this.formGroup=this.form.group({
      Name:[''],
      BaseAmount:['']
    });
  }

  ngOnInit(): void { }

  sendData():any {
    console.log(this.formGroup.value);
    
    this.productService.addProduct(this.formGroup.value).subscribe(response => {
      this.router.navigateByUrl('/product-list');
    });
  
  }
}
