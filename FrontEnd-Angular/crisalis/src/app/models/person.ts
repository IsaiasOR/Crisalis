import { Business } from "./business";
import { Order } from "./order";

export class Person {
    Id!:Number;
    FirstName!: String;
    LastName!: String;
    DNI!:Number;
    Email!:String;
    PhoneNumber!:String;
    Address!:String;
    ActiveService!: Boolean;
    BusinessSet = new Set<Business>();

    constructor(firstName:String,
        lastName:String,
        dni:Number,
        email:String,
        phoneNumber:String,
        address:String,
        activeService:Boolean) {
            this.DNI = dni;
            this.FirstName = firstName;
            this.LastName = lastName
            this.Email = email;
            this.PhoneNumber = phoneNumber;
            this.Address = address;
            this.ActiveService = activeService;
    }
}