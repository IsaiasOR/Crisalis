import { Component, OnInit } from '@angular/core';
import { CrudService } from 'src/app/service/product/crud.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit{
  Persons:any;

  constructor(
    private crudService:CrudService
  ) {}

  ngOnInit(): void {
    this.crudService.getProduct().subscribe(response => {
      console.log(response);
    });
  }
}
