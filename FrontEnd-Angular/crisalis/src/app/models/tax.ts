import { Product } from "./product";
import { Service } from "./service";

export class Tax {
    Id!: Number;
    NameTax!: String;
    Percentage!: Number;
    Products = new Set<Product>();
    Services = new Set<Service>();

    constructor(name: String,
        percentage: Number) {
            this.NameTax = name;
            this.Percentage = percentage;
    }
}