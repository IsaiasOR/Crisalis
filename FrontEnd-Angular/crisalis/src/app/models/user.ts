import { UserRole } from "../enums/userRole";

export class User {
    Id!:Number;
    DNI!:Number;
    FirstName!:String;
    LastName!:String;
    Email!:String;
    PhoneNumber!:String;
    Password!:String;
    Role!:UserRole;
    

    constructor(
        email:String,
        password:String) {
            this.Email = email;
            this.Password = password;
    }
}