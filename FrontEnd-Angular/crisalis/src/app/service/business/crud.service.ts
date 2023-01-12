import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Business } from './business';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  API: string='http://localhost8080/business/new'

  constructor(private clientHttp:HttpClient) { }

  addBusiness(dataBusiness:Business):Observable<any>{
    return this.clientHttp.post(this.API+"?insert=1",dataBusiness);
  }

  getBusiness(){
    return this.clientHttp.get(this.API);
  }
}
