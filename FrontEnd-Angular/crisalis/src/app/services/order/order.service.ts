import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../../models/order';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  //API: string='http://localhost:8080'

  constructor(private clientHttp:HttpClient) { }

  addOrder(dataOrder:Order):Observable<any>{
    return this.clientHttp.post("/api/order/new",dataOrder);
  }

  getOrder(){
    return this.clientHttp.get("/api/order/list");
  }
}