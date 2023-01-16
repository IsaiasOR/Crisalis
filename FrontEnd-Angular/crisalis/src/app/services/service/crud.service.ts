import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Service } from './service';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  //API: string='http://localhost:8080/service'

  constructor(private clientHttp:HttpClient) { }

  addService(dataService:Service):Observable<any>{
    return this.clientHttp.post("/api/service/new",dataService);
  }

  getService(){
    return this.clientHttp.get("/api/service/list");
  } 
}
