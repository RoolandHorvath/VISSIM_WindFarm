export class TrafficData {
  public id!: number;
  public dateTime!: Date;
  public MMSI!: number;
  public Class!: String;
  public latitude!:number;
  public longitude!:number;
  public sog!:number;
  public cog!:number;
  public heading!:number;

  constructor(init?: Partial<TrafficData>) {
    Object.assign(this, init);
  }
}
