import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Person } from '../../models/person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  API: string='http://localhost:8080/api/client'

  constructor(private clientHttp:HttpClient) { }

  addPerson(dataPerson:Person):Observable<any>{
    return this.clientHttp.post(this.API+"/new",dataPerson);
  }

  getPerson(){
    return this.clientHttp.get(this.API+"/list");
  }

}
