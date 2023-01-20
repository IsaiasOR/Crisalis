export class Users {
    public id: BigInteger;
    public dni: BigInteger;
    public firstName: String;
    public lastName: String;
    public pwd:String;
    public email:String;
    public phoneNumber: String;
    public role: String;
    
    constructor(id:BigInteger,
                dni:BigInteger,
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