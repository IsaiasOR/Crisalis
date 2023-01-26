import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../../models/product';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  API: string='http://localhost:8080/api/user'

  constructor(private clientHttp:HttpClient) { }

  addUser(dataProduct:Product):Observable<any>{
    return this.clientHttp.post(this.API+"/new",dataProduct);
  }

  getUser(){
    return this.clientHttp.get(this.API+"/list");
  }

  deleteUser(id:any):Observable<any>{
    return this.clientHttp.get(this.API+"/delete/"+id);
  }
}
