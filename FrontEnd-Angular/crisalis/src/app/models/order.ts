import { Person } from "./person";
import { User } from "./user";

export class Order {
    Id!:Number;
    DateCreated!: Date;
    TotalAmount!: Number;
    Description!: String;
    Client!: Person;
    User!: User;

    // constructor(dateCreated: Date,
    //     amount: Number,
    //     description: String,
    //     client: Person) {
    //         this.Amount = amount;
    //         this.DateCreated = dateCreated;
    //         this.Description = description;
    // }
}