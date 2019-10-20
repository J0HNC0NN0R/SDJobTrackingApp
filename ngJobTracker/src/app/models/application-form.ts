export class ApplicationForm {
  position: string;
  descriptionURL: string;
  interestLevel: number;
  companyName: string;
  siteUrl: string;
  city: string;
  state: string;

  constructor(
    position?: string,
    descriptionURL?: string,
    interestLevel?: number,
    companyName?: string,
    siteUrl?: string,
    city?: string,
    state?: string
  ) {
    this.position = position;
    this.descriptionURL = descriptionURL;
    this.interestLevel = interestLevel;
    this.companyName = companyName;
    this.siteUrl = siteUrl;
    this.city = city;
    this.state = state;
  }

}
