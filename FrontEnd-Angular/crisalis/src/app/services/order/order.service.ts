import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../../models/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  API: string='http://localhost:8080/api/order'

  constructor(private clientHttp:HttpClient) { }

  addOrder(dataOrder:Order):Observable<any>{
    return this.clientHttp.post(this.API+"/new",dataOrder);
  }

  getOrder(){
    return this.clientHttp.get(this.API+"/list");
  }

  deleteOrder(id:any):Observable<any>{
    return this.clientHttp.delete(this.API+"/delete/"+id);
  }
}