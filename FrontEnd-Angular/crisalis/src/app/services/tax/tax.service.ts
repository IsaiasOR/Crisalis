import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tax } from '../../models/tax';

@Injectable({
  providedIn: 'root'
})
export class TaxService {
  API: string='http://localhost:8080/api/tax'

  constructor(private clientHttp:HttpClient) { }

  addTax(dataTax:Tax):Observable<any>{
    return this.clientHttp.post(this.API+"/new",dataTax);
  }

  getTax(){
    return this.clientHttp.get(this.API+"/list");
  }

  deleteTax(id:any):Observable<any>{
    return this.clientHttp.get(this.API+"/delete/"+id);
  }
}
