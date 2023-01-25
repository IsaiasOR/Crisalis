import { ActiveService } from "../enums/activeService";
import { Business } from "./business";
import { Order } from "./order";

export class Person {
    Id!:BigInteger;
    FirstName!: String;
    LastName!: String;
    DNI!:Number;
    Email!:String;
    PhoneNumber!:String;
    Address!:String;
    ActiveService!:ActiveService;
    BusinessSet = new Set<Business>();
    Orders = new Set<Order>();

    constructor(firstName:String,
        lastName:String,
        dni:Number,
        email:String,
        activeService:ActiveService) {
            this.DNI = dni;
            this.FirstName = firstName;
            this.LastName = lastName
            this.Email = email;
            this.ActiveService = activeService;
    }
}