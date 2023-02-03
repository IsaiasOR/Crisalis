import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  API: string='http://localhost:8080/api/user'

  constructor(
    private clientHttp:HttpClient,
    private router: Router
  ) { }

  getUser(){
    return this.clientHttp.get(this.API+"/list");
  }

  getUserComplete(){
    return this.clientHttp.get(this.API+"/listComplete");
  }

  deleteUser(id:any):Observable<any>{
    return this.clientHttp.delete(this.API+"/deleteById/"+id);
  }

  getSingleUser(id:any):Observable<any> {
    return this.clientHttp.get(this.API+"/findUserById/"+id);
  }

  editUser(id:any, dataUser:any):Observable<any> {
    return this.clientHttp.put(this.API+"/update/"+id,dataUser);
  }
}
