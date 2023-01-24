export class Product {
    id!: Number;
    Name!: String;
    BaseAmount!: Number;
    Guarantee!: Number;

    constructor(name:String,
        baseAmount:Number,) {
            this.Name = name;
            this.BaseAmount = baseAmount;
    }
}