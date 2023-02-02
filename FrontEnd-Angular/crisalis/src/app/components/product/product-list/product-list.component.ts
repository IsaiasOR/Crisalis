import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit{
  Products:any;

  constructor(
    private productService:ProductService
  ) {}

  ngOnInit(): void {
    this.productService.getProduct().subscribe(response => {
      console.log(response);
      this.Products=response;
    });
  }

  deleteRegister(id:any, iControl:any) {
    console.log(id);
    console.log(iControl);
    if(window.confirm("¿Desea borrar el registro?")) {
      this.productService.deleteProduct(id).subscribe((response) => {
        this.Products.splice(iControl,1);
      });
    location.reload();
    }
  }
}
