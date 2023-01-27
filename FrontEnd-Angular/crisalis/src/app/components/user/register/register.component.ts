import { Component } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent {
  formGroup: FormGroup;

  constructor(
    public form:FormBuilder,
    private userService:UserService,
    private router:Router
    ) {

    this.formGroup=this.form.group({
      DNI:[''],
      FirstName:[''],
      LastName:[''],
      Email:[''],
      PhoneNumber:[''],
      Role:[''],
      Password:['']
    });
  }

  sendData():any {
    console.log("Me presionaste");
    console.log(this.formGroup.value);
    
    this.userService.addUser(this.formGroup.value).subscribe();
  
    this.router.navigateByUrl('/user');
  }

}