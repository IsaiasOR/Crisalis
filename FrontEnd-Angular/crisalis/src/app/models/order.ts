import { Person } from "./person";
import { Product } from "./product";
import { Service } from "./service";
import { User } from "./user";

export class Order {
    DateCreated!: Date;
    Amount!: Number;
    Description!: String;
    Products = new Set<Product>();
    Services = new Set<Service>();
    Client!: Person;
    User!: User;

    constructor(dateCreated: Date,
        amount: Number,
        description: String,
        client: Person) {
            this.Amount = amount;
            this.DateCreated = dateCreated;
            this.Description = description;
            this.Client = client;
    }
}