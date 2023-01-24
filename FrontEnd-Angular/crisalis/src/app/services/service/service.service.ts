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
}
