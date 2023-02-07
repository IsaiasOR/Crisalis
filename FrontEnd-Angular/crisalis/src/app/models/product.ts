export class Product {
    Id!: Number;
    Name!: String;
    BaseAmount!: Number;

    constructor(name:String,
        baseAmount:Number,) {
            this.Name = name;
            this.BaseAmount = baseAmount;
    }
}