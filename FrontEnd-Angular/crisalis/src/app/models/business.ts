import { Person } from "./person";

export class Business {
    BusinessName!: String;
    ActStartDate!: Date;
    CUIT!: String;
    Clients = new Set<Person>();

    constructor(businessName:String,
        actStartDate:Date,
        cuit:String,
        clients:Set<Person>) {
            this.BusinessName = businessName;
            this.ActStartDate = actStartDate;
            this.CUIT = cuit;
            this.Clients = clients;
    }
}