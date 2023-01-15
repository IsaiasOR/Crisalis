import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Business } from './business';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  //API: string='http://localhost:8080'

  constructor(private clientHttp:HttpClient) { }

  addBusiness(dataBusiness:Business):Observable<any>{
    return this.clientHttp.post("/business/new",dataBusiness);
  }

  getBusiness(){
    return this.clientHttp.get("/business/list");
  }
}
