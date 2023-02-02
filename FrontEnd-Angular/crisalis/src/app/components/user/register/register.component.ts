import { AuthenticationService } from 'src/app/services/user/authentication/authentication.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  public registerForm!: FormGroup;

  constructor(
    private authenticationService: AuthenticationService,
    private formBuilder:FormBuilder
    ) {

    this.registerForm=this.formBuilder.group({
      DNI:[''],
      FirstName:[''],
      LastName:[''],
      PhoneNumber:[''],
      Role:[''],
      Email:[''],
      Password:['']
    });
  }

  ngOnInit(): void {
    
  }

  public sendData() {
    this.authenticationService.register(this.registerForm.value);
  }
}