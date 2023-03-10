import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-user-modify-data',
  templateUrl: './user-modify-data.component.html',
  styleUrls: ['./user-modify-data.component.css']
})
export class UserModifyDataComponent implements OnInit {
  formUser: FormGroup;
  id:any;

  constructor(
    private activeRoute:ActivatedRoute,
    private userService:UserService,
    public formBuilder:FormBuilder,
    private router:Router
  ) {
    this.id = this.activeRoute.snapshot.paramMap.get('Id');
    console.log(this.id);

    this.userService.getSingleUser(this.id).subscribe(
      response => {
        console.log(response);
        this.formUser.setValue({
          DNI:response['dni'],
          FirstName:response['firstName'],
          LastName:response['lastName'],
          PhoneNumber:response['phoneNumber'],
          Role:response['userRole'],
          Email:response['email'],
          Password:response['password']
        });
      }
    );

    this.formUser = this.formBuilder.group({
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

  sendData():any {
    console.log(this.id);
    console.log(this.formUser.value);
    this.userService.editUser(this.id, this.formUser.value).subscribe(() => {
      this.router.navigateByUrl('/user-list');
    });
  }
}