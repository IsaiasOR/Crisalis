import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Service } from '../../models/service';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  API: string='http://localhost:8080/api/service'

  constructor(private clientHttp:HttpClient) { }

  addService(dataService:Service):Observable<any>{
    return this.clientHttp.post(this.API+"/new",dataService);
  }

  getService(){
    return this.clientHttp.get(this.API+"/list");
  }

  getServiceComplete(){
    return this.clientHttp.get(this.API+"/listComplete");
  }

  deleteService(id:any):Observable<any>{
    return this.clientHttp.delete(this.API+"/delete/"+id);
  }

  getSingleService(id:any):Observable<any> {
    return this.clientHttp.get(this.API+"/findService/"+id);
  }

  editService(id:any, dataService:any):Observable<any> {
    return this.clientHttp.put(this.API+"/update/"+id,dataService);
  }

  updateStatus(id:any):Observable<any> {
    return this.clientHttp.get(this.API+"/updateStatus/"+id);
  }
}
