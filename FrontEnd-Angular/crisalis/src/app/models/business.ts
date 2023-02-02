import { Person } from "./person";

export class Business {
    Id!:Number;
    BusinessName!: String;
    ActStartDate!: Date;
    CUIT!: String;
    Clients = new Set<Person>();

    constructor(id:Number,
        businessName:String,
        actStartDate:Date,
        cuit:String) {
            this.Id = id;
            this.BusinessName = businessName;
            this.ActStartDate = actStartDate;
            this.CUIT = cuit;
    }
}