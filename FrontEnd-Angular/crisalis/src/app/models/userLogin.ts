export class UserLogin {
    Email!:String;
    Password!:String;
    

    constructor(
        email:String,
        password:String) {
            this.Email = email;
            this.Password = password;
    }
}