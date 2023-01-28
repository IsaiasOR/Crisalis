import { AuthenticationService } from 'src/app/services/user/authentication/authentication.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  public loginForm!: FormGroup;

  constructor(
    private authenticationService: AuthenticationService,
    private formBuilder:FormBuilder
  ) {
    this.loginForm=this.formBuilder.group({
      Email:[''],
      Password:['']
    });
  }

  ngOnInit() {}

  public sendData() {
    this.authenticationService.login(this.loginForm.value);
  }

  // public userLogin() {
  //   this.userService.loginUser(this.user).subscribe((token) => {
  //     localStorage.setItem(this.tokenKey, token);
  //     this.router.navigate(['/']);
  //   });
  // }
  

  // userLogin() {
    // console.log(this.user);
    // this.userService.loginUser(this.user).subscribe(data => {
      // alert("Login Successfully")
    // }, error => alert("Sorry. Please enter correct Email and Password."))
  // }
}