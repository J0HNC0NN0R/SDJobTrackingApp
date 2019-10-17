export class Application {
  id: number;
  userId: number;
  companyId: number;
  position: string;
  descriptionURL: string;
  interestLevel: number;

  constructor(
    id?: number,
    userId?: number,
    companyId?: number,
    position?: string,
    descriptionURL?: string,
    interestLevel?: number
  ) {
    this.id = id;
    this.userId = userId;
    this.companyId = companyId;
    this.position = position;
    this.descriptionURL = descriptionURL;
    this.interestLevel = interestLevel;
  }
}
