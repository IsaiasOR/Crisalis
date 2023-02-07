import { Component } from '@angular/core';
import { OrderService } from 'src/app/services/order/order.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})

export class OrderListComponent {
  Orders:any;

  constructor(
    private orderService:OrderService
  ) { 
  }

  ngOnInit(): void {
    this.orderService.listOrder().subscribe(response => {
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
      location.reload();
    }
  }

}
