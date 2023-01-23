export class User {
    id!: Number;
    dni!: Number;
    firstName!: String;
    lastName!: String;
    pwd!:String;
    email!:String;
    phoneNumber!: String;
    role!: String;
    
    constructor(id:Number,
                dni:Number,
                firstName: String,
                lastName: String,
                pwd:String,
                email:String,
                phoneNumber:String,
                role:String) {
        this.id = id;
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pwd = pwd;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}