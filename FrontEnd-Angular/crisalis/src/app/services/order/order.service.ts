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

  addOrder(dataOrder:Order){
    return this.clientHttp.post(this.API+"/new",dataOrder);
  }

  listOrder(){
    return this.clientHttp.get(this.API+"/list");
  }

  deleteOrder(id:any):Observable<any>{
    return this.clientHttp.delete(this.API+"/delete/"+id);
  }

  findOrder(id:any):Observable<any> {
    return this.clientHttp.get(this.API+"/findOrder/"+id);
  }

  editOrder(id:any, dataOrder:any):Observable<any> {
    return this.clientHttp.put(this.API+"/update/"+id,dataOrder);
  }
}