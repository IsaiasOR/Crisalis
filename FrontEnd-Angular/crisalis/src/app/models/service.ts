export class Service {
    Id!: Number;
    Name!: String;
    BaseAmount!: Number;
    MonthlyCost!: Number;
    SupportChange!: Number;


    constructor(name:String,
        baseAmount:Number,) {
            this.Name = name;
            this.BaseAmount = baseAmount;
    }
}