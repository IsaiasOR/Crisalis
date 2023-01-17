import { Component, OnInit } from '@angular/core';
import { CrudService } from 'src/app/services/order/crud.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit{
  Orders:any;

  constructor(
    private crudService:CrudService
  ) {}

  ngOnInit(): void {
    this.crudService.getOrder().subscribe(response => {
      console.log(response);
      this.Orders=response;
    });
  }
}
