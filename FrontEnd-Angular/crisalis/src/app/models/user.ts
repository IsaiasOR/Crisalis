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
    

    constructor(dni:Number,
        firstName: String,
        lastName: String,
        phoneNumber: String,
        role: UserRole,
        email:String,
        password:String) {
            this.DNI = dni;
            this.FirstName = firstName;
            this.LastName = lastName;
            this.PhoneNumber = phoneNumber;
            this.Role = role;
            this.Email = email;
            this.Password = password;
    }
}