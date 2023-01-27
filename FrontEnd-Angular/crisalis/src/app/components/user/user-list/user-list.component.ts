import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})

export class UserListComponent implements OnInit {
  Users:any;

  constructor(
    private userService:UserService
  ) {}

  ngOnInit(): void {
    this.userService.getUser().subscribe(response => {
      console.log(response);
      this.Users=response;
    });
  }

  deleteRegister(id:any, iControl:any) {
    console.log(id);
    console.log(iControl);
    if(window.confirm("¿Desea borrar el registro?")) {
      this.userService.deleteUser(id).subscribe((response) => {
        this.Users.splice(iControl,1);
      });
    }
  }

}