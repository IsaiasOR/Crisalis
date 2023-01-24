import { Product } from "./product";
import { Service } from "./service";

export class Tax {
    id!: Number;
    Name!: String;
    Percentage!: Number;
    Products = new Set<Product>();
    Services = new Set<Service>();

    constructor(name: String,
        percentage: Number) {
            this.Name = name;
            this.Percentage = percentage;
    }
}