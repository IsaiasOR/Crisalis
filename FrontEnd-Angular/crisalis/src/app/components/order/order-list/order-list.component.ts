import { Component } from '@angular/core';
import { Product } from 'src/app/models/product';
import { OrderService } from 'src/app/services/order/order.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})

export class OrderListComponent {
  Orders:any;
  listProducts: any;
  array: any;

  constructor(
    private orderService:OrderService,
  ) {
    this.array = [];
  }

  ngOnInit(): void {
    this.orderService.getOrder().subscribe(response => {
      console.log(response);
      this.Orders=response;
      
      console.log(this.Orders[0]['Products']);
      
    });
  }

  deleteRegister(id:any, iControl:any) {
    console.log(id);
    console.log(iControl);
    if(window.confirm("¿Desea borrar el registro?")) {
      this.orderService.deleteOrder(id).subscribe((response) => {
        this.Orders.splice(iControl,1);
      });
      location.reload();
    }
  }
}
