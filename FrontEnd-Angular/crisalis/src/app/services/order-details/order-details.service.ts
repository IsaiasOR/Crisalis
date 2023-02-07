import { Injectable } from '@angular/core';
import { OrderDetails } from 'src/app/models/orderDetails';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderDetailsService {

  API: string='http://localhost:8080/api/orderDetails'

  constructor(private clientHttp:HttpClient) { }

  addOrderDetails(dataOrderDetails:OrderDetails){
    return this.clientHttp.post(this.API+"/new",dataOrderDetails);
  }

  getListOrderDetails(){
    return this.clientHttp.get(this.API+"/list");
  }

  getOrderDetailsNoOrder(){
    return this.clientHttp.get(this.API+"/orderDetailsNoOrder");
  }

  deleteOrderDetails(id:any):Observable<any>{
    return this.clientHttp.delete(this.API+"/delete/"+id);
  }

  findOrderDetails(id:any):Observable<any> {
    return this.clientHttp.get(this.API+"/findOrderDetails/"+id);
  }

  editOrderDetails(id:any, dataOrderDetails:any):Observable<any> {
    return this.clientHttp.put(this.API+"/update/"+id,dataOrderDetails);
  }
}