import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { User } from 'src/app/models/user';
import { UserLogin } from 'src/app/models/userLogin';

@Injectable({
    providedIn: 'root',
})
export class AuthenticationUser {
    API: string='http://localhost:8080/api/user'

    constructor(private clientHttp: HttpClient) {}

    loginUser(userLogin: UserLogin): Observable<any> {
        return this.clientHttp.post(this.API+"/login", userLogin);
    }
    
    registerUser(dataProduct:User):Observable<any>{
        return this.clientHttp.post(this.API+"/new",dataProduct);
    }
}