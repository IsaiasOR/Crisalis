import { UserRole } from "../enums/userRole";

export class User {
    DNI!:Number;
    FirstName!:String;
    LastName!:String;
    Email!:String;
    PhoneNumber!:String;
    Password!:String;
    Role!:UserRole;
    

    constructor(dni:Number,
        firstName:String,
        lastname:String,
        email:String,
        phoneNumber:String,
        password:String,
        role:UserRole) {
            this.DNI = dni;
            this.FirstName = firstName;
            this.LastName = lastname;
            this.Email = email;
            this.PhoneNumber = phoneNumber;
            this.Password = password;
            this.Role = role;
    }
}