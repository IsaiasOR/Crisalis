import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../../models/product';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  //API: string='http://localhost:8080'

  constructor(private clientHttp:HttpClient) { }

  addProduct(dataProduct:Product):Observable<any>{
    return this.clientHttp.post("/api/product/new",dataProduct);
  }

  getProduct(){
    return this.clientHttp.get("/api/product/list");
  }
}
