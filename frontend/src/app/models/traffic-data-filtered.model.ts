export class TrafficDataFilteredDTO {
    public mmsi!: number;
    public avgSOG!: number;
    public avgCOG!: number;
    public date!:number;

    constructor(init?: Partial<TrafficDataFilteredDTO>) {
      Object.assign(this, init);
    }
  }

