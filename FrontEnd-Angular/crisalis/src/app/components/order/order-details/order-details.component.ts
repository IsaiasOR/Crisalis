import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OrderService } from 'src/app/services/order/order.service';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {
  id:any;
  orderDetails:any;

  constructor(
    private activeRote:ActivatedRoute,
    private orderService:OrderService,
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);
  }

  ngOnInit(): void {
    this.orderService.getSingleOrderDetails(this.id).subscribe(response => {
      console.log(response);
      this.orderDetails=response;
    });
  }
}