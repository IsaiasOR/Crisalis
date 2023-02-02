import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-product-edity',
  templateUrl: './product-edity.component.html',
  styleUrls: ['./product-edity.component.css']
})
export class ProductEdityComponent implements OnInit {
  formProduct: FormGroup;
  id:any;

  constructor(
    private activeRote:ActivatedRoute,
    private productService:ProductService,
    public formBuilder:FormBuilder,
    private router:Router
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);

    this.productService.getSingleProduct(this.id).subscribe(
      response => {
        console.log(response);
        this.formProduct.setValue({
          Name:response['name'],
          BaseAmount:response['baseAmount'],
          Status:response['status']
        });
      }
    );

    this.formProduct = this.formBuilder.group({
      Name:[''],
      BaseAmount:[''],
      Status:['']
    });

  }

  ngOnInit(): void {
  }

  sendData():any {
    console.log(this.id);
    console.log(this.formProduct.value);
    this.productService.editProduct(this.id, this.formProduct.value).subscribe(() => {
      this.router.navigateByUrl('/product-list');
    });
  }
}