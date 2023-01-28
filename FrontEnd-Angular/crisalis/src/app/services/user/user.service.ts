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

  deleteUser(id:any):Observable<any>{
    return this.clientHttp.delete(this.API+"/deleteById/"+id);
  }
}
