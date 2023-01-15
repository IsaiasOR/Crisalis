import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tax } from './tax';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  //API: string='http://localhost:8080/tax'

  constructor(private clientHttp:HttpClient) { }

  addTax(dataTax:Tax):Observable<any>{
    return this.clientHttp.post("/tax/new",dataTax);
  }

  getTax(){
    return this.clientHttp.get("/tax/list");
  } 
}