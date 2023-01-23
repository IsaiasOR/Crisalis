import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user';

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  private baseUrl="http://localhost:8080/api/user/login"

  constructor(private httpClient: HttpClient) {}

  loginUser(user: User): Observable<object> {
    console.log(user);
    return this.httpClient.post(this.baseUrl, user);
  }

}