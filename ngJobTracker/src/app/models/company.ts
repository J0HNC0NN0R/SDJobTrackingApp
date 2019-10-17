export class Company {
  id: number;
  name: string;
  siteURL: string;

  constructor(
    id?: number,
    name?: string,
    siteURL?: string
    ) {
    this.id = id;
    this.name = name;
    this.siteURL = siteURL;
  }
}
