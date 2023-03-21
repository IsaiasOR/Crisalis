export class Tax {
    Id!: Number;
    NameTax!: String;
    Percentage!: Number;

    constructor(name: String,
        percentage: Number) {
            this.NameTax = name;
            this.Percentage = percentage;
    }
}