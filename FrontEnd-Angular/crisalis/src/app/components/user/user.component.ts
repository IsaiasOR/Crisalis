import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
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
