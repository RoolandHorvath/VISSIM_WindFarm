export class Asset {
  public id!: number;
  public name!: string;
  public latitude!: number;
  public longitude!: number;
  constructor(init?: Partial<Asset>) {
    Object.assign(this, init);
  }
}
