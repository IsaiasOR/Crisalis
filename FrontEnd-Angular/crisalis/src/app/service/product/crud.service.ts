import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  API: string='http://localhost8080/product/new'

  constructor(private clientHttp:HttpClient) { }

  addProduct(dataProduct:Product):Observable<any>{
    return this.clientHttp.post(this.API+"?insert=1",dataProduct);
  }

  getProduct(){
    return this.clientHttp.get(this.API);
  }
}
