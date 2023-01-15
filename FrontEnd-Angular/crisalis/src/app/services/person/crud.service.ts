import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Person } from './person';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  //API: string='http://localhost:8080/client'

  constructor(private clientHttp:HttpClient) { }

  addPerson(dataPerson:Person):Observable<any>{
    return this.clientHttp.post("/client/new",dataPerson);
  }

  getPerson(){
    return this.clientHttp.get("/client/list");
  }

}
