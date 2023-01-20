export class Order {
    id!: BigInteger;
    dateCreated!: Date;
    amount!: DoubleRange;
    description!: String;
    products!: BigInteger;
    services!: BigInteger;
    client!: BigInteger;
    taxes!: BigInteger;
    user!: BigInteger;
}