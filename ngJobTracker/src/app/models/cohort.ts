export class Cohort {
  id: number;
  startDate: Date;
  endDate: Date;
  name: string;
  nickname: string;

  constructor(
    id?: number,
    startDate?: Date,
    endDate?: Date,
    name?: string,
    nickname?: string
  ) {
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.name = name;
    this.nickname = nickname;
  }
}
