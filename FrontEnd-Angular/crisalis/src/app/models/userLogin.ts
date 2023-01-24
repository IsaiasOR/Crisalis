export class UserLogin {
    DNI!:Number;
    FirstName!:String;
    LastName!:String;
    Email!:String;
    PhoneNumber!:String;
    Password!:String;
    Role!:String
    

    constructor(dni:Number,
        firstName:String,
        lastname:String,
        email:String,
        phoneNumber:String,
        password:String,
        role:String) {
            this.DNI = dni;
            this.FirstName = firstName;
            this.LastName = lastname;
            this.Email = email;
            this.PhoneNumber = phoneNumber;
            this.Password = password;
            this.Role = role;
    }
}