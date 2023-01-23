import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/services/order/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit{
  Orders:any;

  constructor(
    private crudService:OrderService
  ) {}

  ngOnInit(): void {
    this.crudService.getOrder().subscribe(response => {
      console.log(response);
      this.Orders=response;
    });
  }
}
