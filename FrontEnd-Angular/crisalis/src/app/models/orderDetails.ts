import { Product } from "./product";
import { Service } from "./service";
import { Tax } from "./tax";

export class OrderDetails {
    Id!:Number;
    Description!: String;
    Product!: Product;
    Quantity!: Number;
    Guarantee!: Number;
    Service!: Service;
    Taxes!: Tax;
}