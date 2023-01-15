import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  //API: string='http://localhost:8080/product'

  constructor(private clientHttp:HttpClient) { }

  addProduct(dataProduct:Product):Observable<any>{
    return this.clientHttp.post("/product/new",dataProduct);
  }

  getProduct(){
    return this.clientHttp.get("/product/list");
  }
}
