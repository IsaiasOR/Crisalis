import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserLogin } from 'src/app/models/userLogin';


@Injectable({
  providedIn: 'root'
})

export class LoginService {

  private baseUrl="http://localhost:8080/api/user/login"

  constructor(private httpClient: HttpClient) {}

  loginUser(userLogin: UserLogin): Observable<object> {
    console.log(userLogin);
    return this.httpClient.post(this.baseUrl, userLogin);
  }

}