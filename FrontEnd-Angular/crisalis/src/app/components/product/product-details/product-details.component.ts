import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  id:any;
  productDetails:any;

  constructor(
    private activeRote:ActivatedRoute,
    private productService:ProductService,
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);
  }

  ngOnInit(): void {
    this.productService.getSingleProduct(this.id).subscribe(response => {
      console.log(response);
      this.productDetails=response;
    });
  }
}