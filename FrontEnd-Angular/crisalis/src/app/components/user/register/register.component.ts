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
    // private userService:UserService,
    // private router:Router
    ) {

    // this.formGroup=this.form.group({
    //   DNI:[''],
    //   FirstName:[''],
    //   LastName:[''],
    //   PhoneNumber:[''],
    //   Role:[''],
    //   Email:[''],
    //   Password:['']
    // });
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

  // sendData():any {
  //   console.log("Me presionaste");
  //   console.log(this.formGroup.value);

  //   this.userService.registerUser(this.formGroup.value).subscribe((token) => {
  //     localStorage.setItem(this.tokenKey, token);
  //     this.router.navigate(['/']);
  //   });
  
  //   this.router.navigateByUrl('/user');
  // }

}

// ngOnInit(): void {
//   this.registerForm = new FormGroup({
//     DNI:new FormControl('', Validators.required),
//     FirstName:new FormControl('', Validators.required),
//     LastName:new FormControl('', Validators.required),
//     PhoneNumber:new FormControl('', Validators.required),
//     Role:new FormControl('', Validators.required),
//     Email:new FormControl('', [Validators.required, Validators.email]),
//     Password:new FormControl('', Validators.required)
//   });
// }