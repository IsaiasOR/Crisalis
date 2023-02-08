import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OrderService } from 'src/app/services/order/order.service';

@Component({
  selector: 'app-order-details-singleton',
  templateUrl: './order-details-singleton.component.html',
  styleUrls: ['./order-details-singleton.component.css']
})
export class OrderDetailsSingletonComponent implements OnInit {
  id:any;
  order:any;

  constructor(
    private activeRote:ActivatedRoute,
    private orderService:OrderService,
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);
  }

  ngOnInit(): void {
    this.orderService.findOrder(this.id).subscribe(response => {
      console.log(response);
      this.order=response;
    });
  }
}