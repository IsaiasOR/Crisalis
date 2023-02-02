import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Business } from '../../models/business';

@Injectable({
  providedIn: 'root'
})
export class BusinessService {
  API: string='http://localhost:8080/api/business'

  constructor(private clientHttp:HttpClient) { }

  addBusiness(dataBusiness:Business):Observable<any> {
    return this.clientHttp.post(this.API+"/new",dataBusiness);
  }

  getBusiness() {
    return this.clientHttp.get(this.API+"/list");
  }

  deleteBusiness(id:any):Observable<any> {
    return this.clientHttp.delete(this.API+"/deleteById/"+id);
  }

  getSingleBusiness(id:any):Observable<any> {
    return this.clientHttp.get(this.API+"/findBusinessById/"+id);
  }

  editBusiness(id:any, dataBusiness:any):Observable<any> {
    return this.clientHttp.put(this.API+"/update/"+id,dataBusiness);
  }
}
