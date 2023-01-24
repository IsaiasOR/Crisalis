import { Component, OnInit } from '@angular/core';
import { UserLogin } from 'src/app/models/userLogin';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  
  user: UserLogin = new UserLogin(0, "","","","","","");

  constructor(private loginService: LoginService) {

  }

  ngOnInit() {}

  userLogin() {
    console.log(this.user);
    this.loginService.loginUser(this.user).subscribe(data => {
      alert("Login Successfully")
    }, error => alert("Sorry. Please enter correct Email and Password."))
  }
  
}