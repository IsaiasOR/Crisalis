import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationUser } from 'src/app/components/user/authentication/authentication.user';
import { User } from 'src/app/models/user';
import { UserLogin } from 'src/app/models/userLogin';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private tokenKey = 'token';

  constructor(
    private authenticationUser: AuthenticationUser,
    private router: Router
  ) {}

  public login(userLogin: UserLogin): void {
    this.authenticationUser
    .loginUser(userLogin)
    .subscribe((token) => {
      localStorage.setItem(this.tokenKey, token);
      alert("Inicio de sesión exitoso.");
      this.router.navigate(['/']);
    }, error => alert("Disculpe. Por favor ingrese correctamente el email y la contraseña."))
  }

  public register(user: User): void {
    this.authenticationUser
      .registerUser(user)
      .subscribe((token) => {
        localStorage.setItem(this.tokenKey, token);
        alert("Registración exitosa.")
        this.router.navigate(['user-list']);
      })
  }

  public logout() {
    localStorage.removeItem(this.tokenKey);
    this.router.navigate(['/login']);
  }

  public isLoggedIn(): boolean {
    let token = localStorage.getItem(this.tokenKey);
    return token != null && token.length > 0;
  }

  public getToken(): string | null {
    return this.isLoggedIn() ? localStorage.getItem(this.tokenKey) : null;
  }
}
