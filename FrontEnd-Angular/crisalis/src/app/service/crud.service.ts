import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Person } from './person';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  API: string='http://localhost8080/person/new'

  constructor(private clientHttp:HttpClient) { }

  addPerson(dataPerson:Person):Observable<any>{
    return this.clientHttp.post(this.API+"?insert=1",dataPerson);
  }

  getPerson(){
    return this.clientHttp.get(this.API);
  }

}
