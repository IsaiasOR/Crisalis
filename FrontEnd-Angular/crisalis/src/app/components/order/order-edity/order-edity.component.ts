import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { OrderService } from 'src/app/services/order/order.service';

@Component({
  selector: 'app-order-edity',
  templateUrl: './order-edity.component.html',
  styleUrls: ['./order-edity.component.css']
})
export class OrderEdityComponent implements OnInit {
  formOrder: FormGroup;
  id:any;

  constructor(
    private activeRote:ActivatedRoute,
    private orderService:OrderService,
    public formBuilder:FormBuilder,
    private router:Router
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);

    this.orderService.getSingleOrder(this.id).subscribe(
      response => {
        console.log(response);
        this.formOrder.setValue({
          
        });
      }
    );

    this.formOrder = this.formBuilder.group({
      
    });

  }

  ngOnInit(): void {
  }

  sendData():any {
    console.log(this.id);
    console.log(this.formOrder.value);
    this.orderService.editOrder(this.id, this.formOrder.value).subscribe(() => {
      this.router.navigateByUrl('/order-list');
    });
  }
}