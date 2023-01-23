import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Service } from '../../models/service';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  //API: string='http://localhost:8080/service'

  constructor(private clientHttp:HttpClient) { }

  addService(dataService:Service):Observable<any>{
    return this.clientHttp.post("/api/service/new",dataService);
  }

  getService(){
    return this.clientHttp.get("/api/service/list");
  } 
}
