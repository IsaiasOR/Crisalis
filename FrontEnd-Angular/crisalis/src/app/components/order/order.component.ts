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
    private orderService:OrderService
  ) {}

  ngOnInit(): void {
    this.orderService.getOrder().subscribe(response => {
      console.log(response);
      this.Orders=response;
    });
  }

  deleteRegister(id:any, iControl:any) {
    console.log(id);
    console.log(iControl);
    if(window.confirm("¿Desea borrar el registro?")) {
      this.orderService.deleteOrder(id).subscribe((response) => {
        this.Orders.splice(iControl,1);
      });
    }
  }
}
