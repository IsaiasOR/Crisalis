import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Service } from './service';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  API: string='http://localhost8080/service/new'

  constructor(private clientHttp:HttpClient) { }

  addService(dataService:Service):Observable<any>{
    return this.clientHttp.post(this.API+"?insert=1",dataService);
  }

  getService(){
    return this.clientHttp.get(this.API);
  } 
}
