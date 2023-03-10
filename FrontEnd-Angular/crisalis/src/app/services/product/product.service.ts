import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  API: string='http://localhost:8080/api/product'

  constructor(private clientHttp:HttpClient) { }

  addProduct(dataProduct:Product):Observable<any>{
    return this.clientHttp.post(this.API+"/new",dataProduct);
  }

  getProduct(){
    return this.clientHttp.get(this.API+"/list");
  }

  getProductComplete(){
    return this.clientHttp.get(this.API+"/listComplete");
  }

  deleteProduct(id:any):Observable<any>{
    return this.clientHttp.delete(this.API+"/deleteById/"+id);
  }

  getSingleProduct(id:any):Observable<any> {
    return this.clientHttp.get(this.API+"/findProduct/"+id);
  }

  editProduct(id:any, dataProduct:any):Observable<any> {
    return this.clientHttp.put(this.API+"/update/"+id,dataProduct);
  }
}
